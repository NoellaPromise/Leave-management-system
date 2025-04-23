package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.Holiday;
import com.ist.africa.hr.leavemanagement.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }
} 