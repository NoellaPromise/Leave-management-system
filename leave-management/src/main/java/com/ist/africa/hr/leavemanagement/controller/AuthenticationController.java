package com.ist.africa.hr.leavemanagement.controller;

import com.ist.africa.hr.leavemanagement.security.JwtTokenProvider;
import com.ist.africa.hr.leavemanagement.service.AuthenticationService;
import com.ist.africa.hr.leavemanagement.dto.LoginRequest;
import com.ist.africa.hr.leavemanagement.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user
        boolean isAuthenticated = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // Generate JWT token
            String token = jwtTokenProvider.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
} 