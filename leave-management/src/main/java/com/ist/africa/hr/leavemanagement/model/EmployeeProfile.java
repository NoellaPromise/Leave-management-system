package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeProfile {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String position;
} 