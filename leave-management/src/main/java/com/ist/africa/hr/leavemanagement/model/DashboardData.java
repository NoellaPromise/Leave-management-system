package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DashboardData {
    private int totalLeaves;
    private int pendingLeaves;
    private int approvedLeaves;
    private int rejectedLeaves;
} 