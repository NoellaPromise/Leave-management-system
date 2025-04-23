package com.ist.africa.hr.leavemanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender emailSender;

    private List<String> notifications = new ArrayList<>();

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public void markAsRead(int index) {
        if (index >= 0 && index < notifications.size()) {
            notifications.set(index, notifications.get(index) + " (Read)");
        }
    }

    public void sendEmailNotification(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendInAppNotification(String userId, String message) {
        // Logic to send in-app notification to a specific user
        addNotification("In-app notification to " + userId + ": " + message);
    }
} 