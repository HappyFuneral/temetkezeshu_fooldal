package hu.temetkezes.demo.providers;

import hu.temetkezes.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public CustomAuthenticationProvider(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public Authentication authenticate(final Authentication authentication){
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        UserDetails user = customUserDetailsService.loadUserByUsername(name);
        System.out.println("CUSTOM AUTH");
        if (user == null){
            System.out.println("USER NULL");
            return null;
        }
        if (!user.getUsername().equals(name) || new BCryptPasswordEncoder().matches(user.getPassword(),password)) {
            System.out.println("WRONG DETAILS");
            return null;
        }

        return authenticateAgainstThirdPartyAndGetAuthentication(name, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    private static UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthentication(String name, String password, Collection<? extends GrantedAuthority> authorities) {
        final UserDetails principal = new User(name, password, authorities);
        return new UsernamePasswordAuthenticationToken(principal, password, authorities);
    }
}