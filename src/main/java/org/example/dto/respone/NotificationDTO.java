package org.example.dto.respone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.UserAccount;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private String notificationId;
    private String title;
    private String content;
    private String sender;
    private String senderName;
    private String receiver;
    private String receiverName;
    private LocalDateTime sentAt;
}
