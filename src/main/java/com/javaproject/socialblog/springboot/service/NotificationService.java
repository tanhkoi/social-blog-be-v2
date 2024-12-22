package com.javaproject.socialblog.springboot.service;

import com.javaproject.socialblog.springboot.model.entities.Notification;

import java.util.List;

public interface NotificationService {
    Notification createNotification(String userId, String title, String message);

    void createNewPostNotification(String userId, String postId, String title, String message);

    List<Notification> getNotifications(boolean unreadOnly);

    Notification markAsRead(String notificationId);

    void deleteNotification(String notificationId);
}
