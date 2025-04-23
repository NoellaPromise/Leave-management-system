package com.ist.africa.hr.leavemanagement.repository;

import com.ist.africa.hr.leavemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here
} 