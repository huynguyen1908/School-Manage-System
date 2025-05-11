package org.example.service;

import org.example.dto.request.CreateNotificationRequest;
import org.example.dto.respone.NotificationDTO;
import org.example.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications();
    List<NotificationDTO> getNotificationsOfUser(String userid);
    NotificationDTO getNotificationContent(String id);
    NotificationDTO createNotification(CreateNotificationRequest request);
}
