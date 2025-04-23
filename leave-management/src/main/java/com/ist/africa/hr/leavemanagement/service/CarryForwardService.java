package com.ist.africa.hr.leavemanagement.service;

public class CarryForwardService {

    private static final int MAX_CARRY_FORWARD_DAYS = 5;

    public double calculateCarryForward(double unusedLeave) {
        return Math.min(unusedLeave, MAX_CARRY_FORWARD_DAYS);
    }
} 