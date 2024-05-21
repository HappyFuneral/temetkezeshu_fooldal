package hu.temetkezes.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
    public void login(){

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public void register(){

    }

}
