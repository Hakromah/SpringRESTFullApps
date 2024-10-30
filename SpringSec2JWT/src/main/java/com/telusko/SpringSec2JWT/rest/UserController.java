package com.telusko.SpringSec2JWT.rest;


import com.telusko.SpringSec2JWT.model.User;
import com.telusko.SpringSec2JWT.service.JwtService;
import com.telusko.SpringSec2JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);

    @PostMapping("/adduser")
    public User register(@RequestBody User user) {
        System.out.println(user);
        user.setPassword(bcrypt.encode(user.getPassword()));
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.createToken(user.getName());
        } else {
            return "Invalid credentials";
        }
    }
}
