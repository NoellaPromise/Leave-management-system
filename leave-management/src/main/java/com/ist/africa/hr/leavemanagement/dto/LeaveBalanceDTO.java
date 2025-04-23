package com.ist.africa.hr.leavemanagement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveBalanceDTO {
    private Long id;
    private Long employeeId;
    private Long leaveTypeId;
    private int year;
    private int totalDays;
    private int usedDays;
    private int pendingDays;
    private int carryOverDays;
    private LocalDateTime expiryDate;
} 