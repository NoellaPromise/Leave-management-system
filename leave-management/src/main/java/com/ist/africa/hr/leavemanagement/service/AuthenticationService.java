package com.ist.africa.hr.leavemanagement.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        // Implement authentication logic (e.g., check against database)
        return "user@example.com".equals(username) && "password123".equals(password);
    }
} 