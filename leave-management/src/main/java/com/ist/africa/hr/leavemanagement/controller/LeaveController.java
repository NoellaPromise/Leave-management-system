package com.ist.africa.hr.leavemanagement.controller;

import com.ist.africa.hr.leavemanagement.model.LeaveApplication;
import com.ist.africa.hr.leavemanagement.model.Document;
import com.ist.africa.hr.leavemanagement.model.LeaveType;
import com.ist.africa.hr.leavemanagement.service.LeaveApplicationService;
import com.ist.africa.hr.leavemanagement.service.LeaveTypeService;
import com.ist.africa.hr.leavemanagement.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @Autowired
    private DocumentService documentService;

    @PostMapping("/apply")
    public ResponseEntity<LeaveApplication> applyForLeave(@RequestBody LeaveApplication leaveApplication,
                                                          @RequestParam(required = false) Document document) {
        LeaveApplication savedApplication = leaveApplicationService.applyForLeave(leaveApplication, document);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping
    public ResponseEntity<List<LeaveApplication>> listLeaves() {
        List<LeaveApplication> leaveApplications = leaveApplicationService.getAllLeaveApplications();
        return ResponseEntity.ok(leaveApplications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveApplication> getLeave(@PathVariable Long id) {
        LeaveApplication leaveApplication = leaveApplicationService.getLeaveApplicationById(id);
        return ResponseEntity.ok(leaveApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveApplication> updateLeave(@PathVariable Long id, @RequestBody LeaveApplication leaveApplication) {
        LeaveApplication updatedLeaveApplication = leaveApplicationService.updateLeaveApplication(id, leaveApplication);
        return ResponseEntity.ok(updatedLeaveApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveApplicationService.deleteLeaveApplication(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/types")
    public ResponseEntity<List<LeaveType>> getLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypeService.getAllLeaveTypes();
        return ResponseEntity.ok(leaveTypes);
    }

    @PostMapping("/upload-document")
    public ResponseEntity<Document> uploadDocument(@RequestParam MultipartFile file) {
        Document document = documentService.uploadDocument(file);
        return ResponseEntity.ok(document);
    }
} 