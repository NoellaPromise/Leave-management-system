package com.ist.africa.hr.leavemanagement.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Extract JWT token from the request header
        String jwtToken = extractJwtFromRequest(request);

        // Validate the token and set the authentication in the context
        if (jwtToken != null && validateToken(jwtToken)) {
            // Set authentication in the context
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(jwtToken, request));
        }

        // Continue with the filter chain
        chain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        // TODO: Implement token validation logic
        return true; // Placeholder
    }

    private Authentication getAuthentication(String token, HttpServletRequest request) {
        // TODO: Extract and return Authentication object from token
        return null; // Placeholder
    }
}
