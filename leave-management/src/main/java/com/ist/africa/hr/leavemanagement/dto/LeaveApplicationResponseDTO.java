package com.ist.africa.hr.leavemanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveApplicationResponseDTO {
    private Long id;
    private Long employeeId;
    private Long leaveTypeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int duration;
    private boolean halfDay;
    private String reason;
    private String status;
    private String approverComments;
} 