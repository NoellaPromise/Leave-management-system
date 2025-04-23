package com.ist.africa.hr.leavemanagement.repository;

import com.ist.africa.hr.leavemanagement.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

    @Query("SELECT lb FROM LeaveBalance lb WHERE lb.employeeId = :employeeId AND lb.year = :year")
    List<LeaveBalance> findLeaveBalancesByEmployeeAndYear(@Param("employeeId") Long employeeId, @Param("year") int year);
} 