package com.ist.africa.hr.leavemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.ist.africa.hr.leavemanagement.model.DashboardData;
import com.ist.africa.hr.leavemanagement.model.LeaveBalance;
import com.ist.africa.hr.leavemanagement.model.LeaveApplication;
import com.ist.africa.hr.leavemanagement.model.EmployeeProfile;
import com.ist.africa.hr.leavemanagement.service.EmployeeService;
import com.ist.africa.hr.leavemanagement.service.LeaveBalanceService;
import com.ist.africa.hr.leavemanagement.service.LeaveApplicationService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardData> getDashboard(@RequestParam Long employeeId) {
        DashboardData dashboardData = employeeService.getDashboardData(employeeId);
        return ResponseEntity.ok(dashboardData);
    }

    @GetMapping("/leave-balance")
    public ResponseEntity<List<LeaveBalance>> getLeaveBalance(@RequestParam Long employeeId) {
        List<LeaveBalance> leaveBalances = leaveBalanceService.getLeaveBalancesForEmployee(employeeId);
        return ResponseEntity.ok(leaveBalances);
    }

    @GetMapping("/leaves")
    public ResponseEntity<List<LeaveApplication>> getLeaveHistory(@RequestParam Long employeeId) {
        List<LeaveApplication> leaveHistory = leaveApplicationService.getLeaveHistoryForEmployee(employeeId);
        return ResponseEntity.ok(leaveHistory);
    }

    @GetMapping("/profile")
    public ResponseEntity<EmployeeProfile> getProfile(@RequestParam Long employeeId) {
        EmployeeProfile profile = employeeService.getEmployeeProfile(employeeId);
        return ResponseEntity.ok(profile);
    }
} 