package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.LeaveApplication;
import com.ist.africa.hr.leavemanagement.repository.LeaveApplicationRepository;
import com.ist.africa.hr.leavemanagement.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalWorkflowService {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    private NotificationService notificationService;

    public void routeToManager(Long applicationId) {
        // Logic to route leave application to the appropriate manager
        LeaveApplication application = leaveApplicationRepository.findById(applicationId).orElseThrow();
        Long managerId = application.getManagerId();
        notificationService.addNotification("Leave application " + applicationId + " routed to manager " + managerId);
    }

    public void handleApproval(Long applicationId) {
        // Logic to handle approval
        LeaveApplication application = leaveApplicationRepository.findById(applicationId).orElseThrow();
        application.setStatus(LeaveApplication.Status.APPROVED);
        leaveApplicationRepository.save(application);
        notificationService.addNotification("Leave application " + applicationId + " approved.");
    }

    public void handleRejection(Long applicationId) {
        // Logic to handle rejection
        LeaveApplication application = leaveApplicationRepository.findById(applicationId).orElseThrow();
        application.setStatus(LeaveApplication.Status.REJECTED);
        leaveApplicationRepository.save(application);
        notificationService.addNotification("Leave application " + applicationId + " rejected.");
    }

    public void updateLeaveBalance(Long applicationId, boolean isApproved) {
        // Logic to update leave balance based on approval status
        LeaveApplication application = leaveApplicationRepository.findById(applicationId).orElseThrow();
        if (isApproved) {
            // Update leave balance logic
            notificationService.addNotification("Leave balance updated for application " + applicationId);
        }
    }
} 