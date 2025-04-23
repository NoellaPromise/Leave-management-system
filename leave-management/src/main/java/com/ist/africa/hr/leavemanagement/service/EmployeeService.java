package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.EmployeeProfile;
import com.ist.africa.hr.leavemanagement.model.DashboardData;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeProfile getEmployeeProfile(Long employeeId) {
        // Placeholder for actual logic to fetch employee profile
        return new EmployeeProfile();
    }

    public DashboardData getDashboardData(Long employeeId) {
        // Placeholder for actual logic to fetch dashboard data
        return new DashboardData();
    }
} 