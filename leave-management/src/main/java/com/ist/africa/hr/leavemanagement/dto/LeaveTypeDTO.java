package com.ist.africa.hr.leavemanagement.dto;

import lombok.Data;

@Data
public class LeaveTypeDTO {
    private Long id;
    private String name;
    private String description;
    private int maxDays;
    private boolean documentRequired;
    private boolean active;
} 