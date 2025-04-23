package com.ist.africa.hr.leavemanagement.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;
    private String department;
    private String position;
    private String role;
    private boolean enabled;
} 