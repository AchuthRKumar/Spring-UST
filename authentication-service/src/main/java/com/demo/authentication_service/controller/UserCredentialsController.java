package com.demo.authentication_service.controller;

import com.demo.authentication_service.entity.UserCredentialsEntity;
import com.demo.authentication_service.service.JwtService;
import com.demo.authentication_service.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserCredentialsController {
    @Autowired
    JwtService jwtService;
    @Autowired
    private UserCredentialsService userCredService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserCredentialsEntity register(@RequestBody UserCredentialsEntity user) {
        return userCredService.register(user);
    }

    @GetMapping("/validate/token")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean validateToken(@RequestParam String token) {
        return userCredService.verifyToken(token);
    }

    @PostMapping("/validate/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getToken(@RequestBody UserCredentialsEntity user) {
        System.out.println("user : " + user);
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        System.out.println("authenticated?? : " + authenticate.isAuthenticated());
        if(authenticate.isAuthenticated()) {
            return userCredService.generateToken(user.getName());
        }
        return null;
    }
}

