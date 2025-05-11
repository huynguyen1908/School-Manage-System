package org.example.mapper;

import org.example.dto.respone.DepartmentDTO;
import org.example.dto.respone.NotificationDTO;
import org.example.entity.Notification;
import org.example.entity.UserAccount;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotificationMapper {

    private final UserAccountService userAccountService;

    public NotificationMapper(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public NotificationDTO toDTO(Notification notification) {
        NotificationDTO dto = new NotificationDTO();
        dto.setNotificationId(notification.getNotificationId());
        dto.setTitle(notification.getTitle());
        dto.setContent(notification.getContent());
        dto.setSentAt(notification.getSentAt());

        UserAccount sender = notification.getSender();
        dto.setSender(sender.getUserId());
        dto.setSenderName(userAccountService.getUserFullName(sender));

        UserAccount receiver = notification.getReceiver();
        dto.setReceiver(receiver.getUserId());
        dto.setReceiverName(userAccountService.getUserFullName(receiver));

        return dto;
    }
}
