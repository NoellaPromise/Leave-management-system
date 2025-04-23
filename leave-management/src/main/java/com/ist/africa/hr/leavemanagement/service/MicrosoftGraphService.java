package com.ist.africa.hr.leavemanagement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

@Service
public class MicrosoftGraphService {

    @Value("${microsoft.graph.api.url}")
    private String graphApiUrl;

    private final RestTemplate restTemplate;

    public MicrosoftGraphService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchUserProfilePicture(String accessToken) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            RequestEntity<Void> request = new RequestEntity<>(headers, HttpMethod.GET, URI.create(graphApiUrl + "/me/photo/$value"));
            ResponseEntity<byte[]> response = restTemplate.exchange(request, byte[].class);

            byte[] imageBytes = response.getBody();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch profile picture", e);
        }
    }
} 