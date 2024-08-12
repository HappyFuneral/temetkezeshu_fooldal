package hu.temetkezes.demo.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.temetkezes.demo.domain.ApiAuthentication;
import hu.temetkezes.demo.enums.LoginType;
import hu.temetkezes.demo.enums.TokenType;
import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.requests.LoginRequest;
import hu.temetkezes.demo.services.JwtService;
import hu.temetkezes.demo.services.UserDataService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Map;

import static hu.temetkezes.demo.utils.RequestUtils.getResponse;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final UserDataService userService;
    private final JwtService jwtService;

    protected AuthenticationFilter(UserDataService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        super(new AntPathRequestMatcher("/api/login",POST.name()), authenticationManager);
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
       try{
           var user = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE,true).readValue(request.getInputStream(), LoginRequest.class);
           userService.updateLoginAttempt(user.getEmail(), LoginType.LOGIN_ATTEMPT);
           var authentication = ApiAuthentication.unauthenticated(user.getEmail(),user.getPassword());
           return getAuthenticationManager().authenticate(authentication);
       } catch (Exception exception){
           log.error(exception.getMessage());
           //handleErrorResponse(request,response,exception);
           return null;

       }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws AuthenticationException, IOException, ServletException {
       var user = (User) authResult.getPrincipal();
       userService.updateLoginAttempt(user.getEmail(), LoginType.LOGIN_SUCCESS);
       var httpResponse = user.isMfa() ? sendQrCode(request,user) : sendResponse(request,response, user);
       response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(OK.value());
        var out = response.getOutputStream();
        var mapper = new ObjectMapper();
        mapper.writeValue(out,httpResponse);
        out.flush();
    }

    private Object sendQrCode(HttpServletRequest request, User user) {
        return getResponse(request, Map.of("user", user), "Please Enter QR code", OK);
    }

    private Object sendResponse(HttpServletRequest request, HttpServletResponse response, User user) {
    jwtService.addCookie(response,user, TokenType.ACCESS);
    jwtService.addCookie(response,user,TokenType.REFRESH);
    return getResponse(request, Map.of("user",user),"Login Succes", OK);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
