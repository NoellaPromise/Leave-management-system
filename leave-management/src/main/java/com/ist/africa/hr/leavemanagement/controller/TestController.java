package com.ist.africa.hr.leavemanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public Map<String, Object> getTestMessage() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello, Africa HR!");
        response.put("timestamp", LocalDateTime.now());
        return response;
    }
} 