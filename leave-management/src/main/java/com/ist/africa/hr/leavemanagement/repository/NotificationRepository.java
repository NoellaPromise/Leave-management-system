package com.ist.africa.hr.leavemanagement.repository;

import com.ist.africa.hr.leavemanagement.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Custom query methods can be added here
} 