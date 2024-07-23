package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final CustomUserDetailsService userService;

    @Autowired
    public AuthController(CustomUserDetailsService userService) {
        this.userService = userService;
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public void register(){

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        System.out.println(username+"-------"+password);

        Authentication authentication = authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String generatedString = UUID.randomUUID().toString();
        AuthResponse authResponse = new AuthResponse(loginRequest.getId(),loginRequest.getUsername(),loginRequest.getRole(),generatedString);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    private Authentication authenticate(String username, String password) {


        System.out.println(username+"-------"+password);

        UserDetails userDetails = userService.loadUserByUsername(username);

        System.out.println("Sig in in user details"+ userDetails);

        if(userDetails == null) {
            throw new BadCredentialsException("Invalid username and password");
        }
        if(!new BCryptPasswordEncoder().matches(password,userDetails.getPassword())) {
            System.out.println("Sign in userDetails - password mismatch"+userDetails);
            throw new BadCredentialsException("Invalid password");
        }
        final UserDetails principal = new org.springframework.security.core.userdetails.User(username, password, userDetails.getAuthorities());
        return new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());

    }
}
