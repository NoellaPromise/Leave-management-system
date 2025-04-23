package com.ist.africa.hr.leavemanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveApplicationRequestDTO {
    private Long employeeId;
    private Long leaveTypeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean halfDay;
    private String reason;
} 