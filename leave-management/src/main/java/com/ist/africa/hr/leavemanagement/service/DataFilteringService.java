package com.ist.africa.hr.leavemanagement.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;

public class DataFilteringService {

    public List<String> filterDataBasedOnRole(List<String> data) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (roles.contains("ROLE_MANAGER")) {
            // Filter data for managers
            return data.stream().filter(d -> d.contains("Manager"))
                    .collect(Collectors.toList());
        } else if (roles.contains("ROLE_ADMIN")) {
            // Admins can see all data
            return data;
        } else {
            // Default filtering for staff
            return data.stream().filter(d -> d.contains("Staff"))
                    .collect(Collectors.toList());
        }
    }
} 