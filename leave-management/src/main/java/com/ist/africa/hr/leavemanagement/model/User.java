package com.ist.africa.hr.leavemanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;
    private String department;
    private String position;
    private Long managerId;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Role {
        STAFF, MANAGER, ADMIN
    }
} 