package com.ist.africa.hr.leavemanagement.repository;

import com.ist.africa.hr.leavemanagement.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    // Custom query methods can be added here
} 