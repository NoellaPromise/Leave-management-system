package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_types")
@Data
@NoArgsConstructor
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int maxDays;
    private boolean documentRequired;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum PredefinedType {
        PTO, SICK_LEAVE, COMPASSIONATE_LEAVE, MATERNITY_LEAVE
    }
} 