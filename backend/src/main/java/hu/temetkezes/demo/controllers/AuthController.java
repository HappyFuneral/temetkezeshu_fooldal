package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.services.OfficeService;
import hu.temetkezes.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public void register(){

    }

}
