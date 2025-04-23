package com.ist.africa.hr.leavemanagement.service;

import com.ist.africa.hr.leavemanagement.dto.*;
import com.ist.africa.hr.leavemanagement.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService {

    private final ModelMapper modelMapper;

    public MapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public LeaveApplicationResponseDTO convertToDto(LeaveApplication leaveApplication) {
        return modelMapper.map(leaveApplication, LeaveApplicationResponseDTO.class);
    }

    public LeaveApplication convertToEntity(LeaveApplicationRequestDTO leaveApplicationRequestDTO) {
        return modelMapper.map(leaveApplicationRequestDTO, LeaveApplication.class);
    }

    public LeaveBalanceDTO convertToDto(LeaveBalance leaveBalance) {
        return modelMapper.map(leaveBalance, LeaveBalanceDTO.class);
    }

    public LeaveTypeDTO convertToDto(LeaveType leaveType) {
        return modelMapper.map(leaveType, LeaveTypeDTO.class);
    }
} 