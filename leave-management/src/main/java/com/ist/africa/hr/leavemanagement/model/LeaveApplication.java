package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_applications")
@Data
@NoArgsConstructor
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long leaveTypeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int duration;
    private boolean halfDay;
    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String approverComments;
    private Long documentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Status {
        PENDING, APPROVED, REJECTED, CANCELLED
    }

    public Long getManagerId() {
        // Placeholder for actual logic to fetch manager ID
        return 1L; // Example manager ID
    }
} 