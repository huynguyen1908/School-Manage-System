package org.example.service.impl;

import org.example.dto.request.CreateNotificationRequest;
import org.example.dto.respone.NotificationDTO;
import org.example.entity.Notification;
import org.example.entity.UserAccount;
import org.example.mapper.NotificationMapper;
import org.example.mapper.UserAccountMapper;
import org.example.repository.NotificationRepository;
import org.example.repository.UserAccountRepository;
import org.example.service.NotificationService;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private NotificationMapper notificationMapper;
    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO getNotificationContent(String id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        return notificationMapper.toDTO(notification);
    }

    @Override
    public NotificationDTO createNotification(CreateNotificationRequest request) {
        UserAccount sender = userAccountRepository.findById(request.getSender())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        UserAccount receiver = userAccountRepository.findById(request.getReceiver())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setTitle(request.getTitle());
        notification.setContent(request.getContent());
        notification.setSender(sender);
        notification.setReceiver(receiver);
        notification.setSentAt(LocalDateTime.now());

        Notification saved = notificationRepository.save(notification);

        return notificationMapper.toDTO(saved);
    }

    @Override
    public List<NotificationDTO> getNotificationsOfUser(String userid) {
        UserAccount userAccount = userAccountRepository.findById(userid).orElseThrow(()-> new RuntimeException("User not found"));
        List<Notification> notifications = notificationRepository.findByReceiver_UserId(userid);
        return notifications.stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }
}

