package hu.temetkezes.demo.services;

import hu.temetkezes.demo.config.JwtConfiguration;
import hu.temetkezes.demo.domain.Token;
import hu.temetkezes.demo.domain.TokenData;
import hu.temetkezes.demo.enums.TokenType;
import hu.temetkezes.demo.function.TriConsumer;
import hu.temetkezes.demo.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static hu.temetkezes.demo.Constants.*;
import static io.jsonwebtoken.Header.JWT_TYPE;
import static io.jsonwebtoken.Header.TYPE;
import static java.util.Arrays.stream;
import static org.apache.tomcat.util.http.SameSiteCookies.NONE;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;


@RequiredArgsConstructor
@Getter
@Setter
public class JwtServiceImpl extends JwtConfiguration implements JwtService {

    private final UserService userService;
    private final Supplier<SecretKey> key = () -> Keys.hmacShaKeyFor(Decoders.BASE64.decode(getSecret()));

    private final Function<String, Claims> claimsFunction = token ->
            Jwts.parser().
                    verifyWith(key.get()).build().parseSignedClaims(token).getPayload();

    private  final Function<String,String> subject = token ->
            getClaimsValue(token,Claims::getSubject);

    private final BiFunction<HttpServletRequest,String,Optional<String>> extractToken = (request, cookieName) ->
            Optional.of(stream(request.getCookies() == null ? new Cookie[]{new Cookie(EMPTY_VALUE,EMPTY_VALUE)}: request.getCookies())
                            .filter(cookie-> Objects.equals(cookieName,cookie.getName()))
                            .map(Cookie::getValue)
                            .findAny()
                    ).orElse(Optional.empty());

    private final BiFunction<HttpServletRequest,String,Optional<Cookie>> extractCookie = (request, cookieName) ->
            Optional.of(stream(request.getCookies() == null ? new Cookie[]{new Cookie(EMPTY_VALUE,EMPTY_VALUE)} : request.getCookies())
                    .filter(cookie -> Objects.equals(cookieName,cookie.getName()))
                    .findAny()
            ).orElse(Optional.empty());

    private final Supplier<JwtBuilder> builder = () -> Jwts.builder()
            .header().add(Map.of(TYPE,JWT_TYPE))
            .and()
            .audience().add(GET_ARRAYS_LLC)
            .and()
            .id(UUID.randomUUID().toString())
            .issuedAt(Date.from(Instant.now()))
            .notBefore(new Date())
            .signWith(key.get(),Jwts.SIG.HS512);

    private final BiFunction<User, TokenType, String> buildToken = (user,type) ->
            Objects.equals(type,TokenType.ACCESS) ? builder.get()
                    .subject(user.getUserId())
                    .claim(AUTHORITIES,user.getRole().getAuthorities())
                    .claim(ROLE,user.getRole()).
                    expiration(Date.from(Instant.now().plusSeconds(getExpiration())))
                    .compact() : builder.get()
                    .subject(user.getUserId())
                    .expiration(Date.from(Instant.now().plusSeconds(getExpiration())))
                    .compact();

    private final TriConsumer<HttpServletResponse,User,TokenType> addCookie = ((response, user, tokenType) -> {
        switch (tokenType) {
            case ACCESS ->{
                var accesToken = createToken(user,Token::getAccess);
                var cookie = new Cookie(tokenType.getValue(),accesToken);
                cookie.setHttpOnly(true);
                //cookie.setSecure(true);
                cookie.setMaxAge(2*60);
                cookie.setPath("/");
                cookie.setAttribute("SameSite",NONE.name());
                response.addCookie(cookie);
            }
            case REFRESH -> {
                var refreshToken = createToken(user,Token::getRefresh);
                var cookie = new Cookie(tokenType.getValue(),refreshToken);
                cookie.setHttpOnly(true);
                //cookie.setSecure(true);
                cookie.setMaxAge(2*60*60);
                cookie.setPath("/");
                cookie.setAttribute("SameSite",NONE.name());
                response.addCookie(cookie);
            }

        }
    });

    private <T> T getClaimsValue(String token, Function<Claims, T> claims) {
        return claimsFunction.andThen(claims).apply(token);
    }

    public Function<String, List<GrantedAuthority>> authorities = token ->
            commaSeparatedStringToAuthorityList(new StringJoiner(AUTHORITY_DELIMITER)
                    .add(claimsFunction.apply(token).get(AUTHORITIES,String.class))
                    .add(ROLE_PREFIX + claimsFunction.apply(token).get(ROLE,String.class)).toString());

    @Override
    public String createToken(User user, Function<Token, String> tokenFunction) {
        var token = Token.builder().access(buildToken.apply(user,TokenType.ACCESS)).refresh(buildToken.apply(user,TokenType.REFRESH)).build();
        return tokenFunction.apply(token);
    }

    @Override
    public Optional<String> extractToken(HttpServletRequest request, String cookieName) {
        return extractToken.apply(request,cookieName);
    }

    @Override
    public void addCookie(HttpServletResponse response, User user, TokenType type) {
        addCookie.accept(response,user,type);
    }

    @Override
    public <T> T getTokenData(String token, Function<TokenData, T> tokenFunction) {
        return tokenFunction.apply(
                TokenData.builder()
                        .valid(true)
                        .authorities(authorities.apply(token))
                        .claims(claimsFunction.apply(token))
                        .user(userService.getUserByUserId(subject.apply(token)))
                        .build()
        );
    }

    @Override
    public void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        var optionalCookie = extractCookie.apply(request,cookieName);
        if(optionalCookie.isPresent()){
            var cookie = optionalCookie.get();
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}
