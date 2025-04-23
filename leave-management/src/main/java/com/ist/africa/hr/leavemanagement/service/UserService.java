package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.model.User;
import com.ist.africa.hr.leavemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
} 