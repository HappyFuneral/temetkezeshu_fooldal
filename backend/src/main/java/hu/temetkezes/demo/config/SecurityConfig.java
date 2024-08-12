package hu.temetkezes.demo.config;


import hu.temetkezes.demo.providers.CustomAuthenticationProvider;
import hu.temetkezes.demo.services.CustomUserDetailsService;
import hu.temetkezes.demo.services.UserDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                authorize -> authorize
                                .requestMatchers(
                                        "/api/login",
                                        "/api/register",
                                        "/api/offices"
                                ).
                        permitAll())

                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
        return http.build();
    }



    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDataService userDetailsService){
        CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider(userDetailsService,passwordEncoder());
        return new ProviderManager(customAuthenticationProvider);
    }


}
