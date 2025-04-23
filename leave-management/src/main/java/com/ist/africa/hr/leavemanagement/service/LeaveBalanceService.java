package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.LeaveBalance;
import com.ist.africa.hr.leavemanagement.model.LeaveBalanceAdjustmentRequest;
import com.ist.africa.hr.leavemanagement.repository.LeaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveBalanceService {

    private static final double PTO_ACCRUAL_RATE = 1.66; // days per month

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    public double calculateAccruedLeave(int monthsWorked) {
        return monthsWorked * PTO_ACCRUAL_RATE;
    }

    public double calculateAvailableLeave(double accruedLeave, double usedLeave) {
        return accruedLeave - usedLeave;
    }

    public void adjustLeaveBalance(LeaveBalanceAdjustmentRequest request) {
        LeaveBalance leaveBalance = leaveBalanceRepository.findById(request.getEmployeeId()).orElseThrow();
        leaveBalance.setTotalDays(leaveBalance.getTotalDays() + request.getAdjustmentDays());
        leaveBalanceRepository.save(leaveBalance);
    }

    public LeaveBalance accrueLeave(LeaveBalance leaveBalance, int monthsWorked) {
        double accruedLeave = monthsWorked * PTO_ACCRUAL_RATE;
        leaveBalance.setTotalDays(leaveBalance.getTotalDays() + accruedLeave);
        return leaveBalanceRepository.save(leaveBalance);
    }

    public List<LeaveBalance> getLeaveBalancesForEmployee(Long employeeId) {
        return leaveBalanceRepository.findLeaveBalancesByEmployeeAndYear(employeeId, LocalDate.now().getYear());
    }
} 