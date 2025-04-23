package com.ist.africa.hr.leavemanagement.controller;

import com.ist.africa.hr.leavemanagement.model.LeaveType;
import com.ist.africa.hr.leavemanagement.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.ist.africa.hr.leavemanagement.model.User;
import com.ist.africa.hr.leavemanagement.service.UserService;
import com.ist.africa.hr.leavemanagement.model.Report;
import com.ist.africa.hr.leavemanagement.service.ReportService;
import com.ist.africa.hr.leavemanagement.model.LeaveBalanceAdjustmentRequest;
import com.ist.africa.hr.leavemanagement.service.LeaveBalanceService;
import com.ist.africa.hr.leavemanagement.model.Holiday;
import com.ist.africa.hr.leavemanagement.service.HolidayService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @Autowired
    private HolidayService holidayService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/leave-types")
    public ResponseEntity<List<LeaveType>> getLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypeService.getAllLeaveTypes();
        return ResponseEntity.ok(leaveTypes);
    }

    @PostMapping("/leave-types")
    public ResponseEntity<LeaveType> createLeaveType(@RequestBody LeaveType leaveType) {
        LeaveType createdLeaveType = leaveTypeService.createLeaveType(leaveType);
        return ResponseEntity.ok(createdLeaveType);
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getReports() {
        List<Report> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    @PostMapping("/leave-balance/adjust")
    public ResponseEntity<Void> adjustLeaveBalance(@RequestBody LeaveBalanceAdjustmentRequest request) {
        leaveBalanceService.adjustLeaveBalance(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/holidays")
    public ResponseEntity<List<Holiday>> getHolidays() {
        List<Holiday> holidays = holidayService.getAllHolidays();
        return ResponseEntity.ok(holidays);
    }
} 