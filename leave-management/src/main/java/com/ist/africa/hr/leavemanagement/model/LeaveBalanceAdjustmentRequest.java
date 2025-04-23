package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeaveBalanceAdjustmentRequest {
    private Long employeeId;
    private int adjustmentDays;
} 