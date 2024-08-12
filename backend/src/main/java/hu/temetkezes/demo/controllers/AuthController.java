package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.domain.ApiAuthentication;
import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.requests.LoginRequest;
import hu.temetkezes.demo.requests.UserRequest;
import hu.temetkezes.demo.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailsService userService;
    private final AuthenticationManager authenticationManager;


    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequest registerRequest){
        userService.createNewUser(registerRequest.getUsername(),registerRequest.getEmail(),registerRequest.getPassword());
        return ResponseEntity.ok().body("csöcs");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest){
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        ApiAuthentication unauthorized = ApiAuthentication.unauthenticated(loginRequest.getEmail(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(unauthorized);
        return ResponseEntity.ok().body("");
    }
}
