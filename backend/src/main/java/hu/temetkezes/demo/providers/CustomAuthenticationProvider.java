package hu.temetkezes.demo.providers;

import hu.temetkezes.demo.domain.ApiAuthentication;
import hu.temetkezes.demo.domain.UserPrincipal;
import hu.temetkezes.demo.exception.ApiException;
import hu.temetkezes.demo.services.UserDataService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

import static java.time.LocalDateTime.now;

@Component

public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private final UserDataService customUserDetailsService;
    @Autowired
    private final BCryptPasswordEncoder encoder;

    public CustomAuthenticationProvider(UserDataService userDataService, BCryptPasswordEncoder encoder){
        this.customUserDetailsService = userDataService;
        this.encoder = encoder;
    }
    @Override
    public Authentication authenticate(final Authentication authentication){
        var apiAuthentication = authenticationFunction.apply(authentication);
        System.out.println("----AUTH---- "+authentication.getPrincipal()+" "+authentication.getCredentials());

        System.out.println("----APIAUTH---- "+apiAuthentication.getEmail());

        var user = customUserDetailsService.getUserByEmail(apiAuthentication.getEmail());
        if(user!=null){
            System.out.println("userid: "+user.getId());
            var userCredential = customUserDetailsService.getUserCredentialsById(user.getId());
            if(!user.isCredentialsNonExpired() ) { throw new ApiException("Credentials are expired.");}
            var userPrincipal = new UserPrincipal(user,userCredential);
            System.out.println("userCredentialId: "+userCredential.getId());
            System.out.println("userPrincipal:" +userPrincipal.getUsername()+","+userPrincipal.getPassword());
            System.out.println(userPrincipal.isCredentialsNonExpired()+" "+userPrincipal.isAccountNonExpired()+" "+userPrincipal.isAccountNonLocked()+" "+userPrincipal.isEnabled());
            validAccount.accept(userPrincipal);
            if (encoder.matches(apiAuthentication.getPassword(), userCredential.getPassword())){
                return  ApiAuthentication.authenticated(user, userPrincipal.getAuthorities());
            } else throw new BadCredentialsException("Email or/and password is incorrect. Please try again");
        } else throw new ApiException("Unable to login");
    }

    private final Function<Authentication, ApiAuthentication> authenticationFunction = authentication -> (ApiAuthentication) authentication;

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiAuthentication.class.isAssignableFrom(authentication);
    }

    private final Consumer<UserPrincipal> validAccount = userPrincipal -> {
        if (!userPrincipal.isAccountNonLocked()) {throw new LockedException("Your account is currently locked");}
        if (!userPrincipal.isEnabled()) {throw new DisabledException("Your account is currently disabled");}
        if (!userPrincipal.isCredentialsNonExpired()) {throw new CredentialsExpiredException("Your password has expired. Please update your password");}
        if (!userPrincipal.isAccountNonExpired()) {throw new DisabledException("Your account has Expired. Please contact administrator");}

    };
}