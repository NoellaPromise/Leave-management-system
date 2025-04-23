package com.ist.africa.hr.leavemanagement.repository;

import com.ist.africa.hr.leavemanagement.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {

    List<LeaveApplication> findByStatusAndEmployeeId(LeaveApplication.Status status, Long employeeId);

    @Query("SELECT la FROM LeaveApplication la WHERE la.employeeId = :employeeId AND la.startDate < :endDate AND la.endDate > :startDate")
    List<LeaveApplication> findOverlappingLeaveApplications(@Param("employeeId") Long employeeId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
} 