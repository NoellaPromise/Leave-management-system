package com.ist.africa.hr.leavemanagement.service;

import org.springframework.security.access.prepost.PreAuthorize;
import java.util.Date;
import java.util.List;
import com.ist.africa.hr.leavemanagement.model.LeaveApplication;
import com.ist.africa.hr.leavemanagement.model.Document;
import com.ist.africa.hr.leavemanagement.repository.LeaveApplicationRepository;
import com.ist.africa.hr.leavemanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ist.africa.hr.leavemanagement.model.LeaveType;
import com.ist.africa.hr.leavemanagement.repository.LeaveTypeRepository;
import java.time.ZoneId;

@Service
public class LeaveApplicationService {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @PreAuthorize("hasRole('STAFF')")
    public boolean validateLeaveRequest(double availableLeave, double requestedLeave) {
        return requestedLeave <= availableLeave;
    }

    @PreAuthorize("hasRole('STAFF')")
    public boolean checkDateConflicts(Date startDate, Date endDate, Long employeeId) {
        List<LeaveApplication> overlappingApplications = leaveApplicationRepository.findOverlappingLeaveApplications(
            employeeId, startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
            endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return overlappingApplications.isEmpty();
    }

    @PreAuthorize("hasRole('STAFF')")
    public boolean validateDocumentRequirements(String leaveType, Document document) {
        LeaveType type = leaveTypeRepository.findByName(leaveType).orElseThrow();
        return !type.isDocumentRequired() || (type.isDocumentRequired() && document != null);
    }

    @PreAuthorize("hasRole('STAFF') or hasRole('MANAGER')")
    public void trackLeaveStatus(String applicationId, String status) {
        // Implement logic to track leave application status
    }

    public LeaveApplication applyForLeave(LeaveApplication leaveApplication, Document document) {
        // Validate leave application
        if (validateLeaveRequest(leaveApplication)) {
            // Save document if provided
            if (document != null) {
                documentRepository.save(document);
                leaveApplication.setDocumentId(document.getId());
            }
            // Save leave application
            return leaveApplicationRepository.save(leaveApplication);
        }
        throw new IllegalArgumentException("Invalid leave application");
    }

    private boolean validateLeaveRequest(LeaveApplication leaveApplication) {
        // Implement validation logic
        return true; // Placeholder
    }

    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationRepository.findAll();
    }

    public LeaveApplication getLeaveApplicationById(Long id) {
        return leaveApplicationRepository.findById(id).orElseThrow();
    }

    public LeaveApplication updateLeaveApplication(Long id, LeaveApplication leaveApplication) {
        LeaveApplication existingApplication = leaveApplicationRepository.findById(id).orElseThrow();
        existingApplication.setStartDate(leaveApplication.getStartDate());
        existingApplication.setEndDate(leaveApplication.getEndDate());
        existingApplication.setReason(leaveApplication.getReason());
        return leaveApplicationRepository.save(existingApplication);
    }

    public void deleteLeaveApplication(Long id) {
        leaveApplicationRepository.deleteById(id);
    }

    public List<LeaveApplication> getLeaveHistoryForEmployee(Long employeeId) {
        return leaveApplicationRepository.findByStatusAndEmployeeId(LeaveApplication.Status.APPROVED, employeeId);
    }
} 