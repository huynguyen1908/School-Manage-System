package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notification")
public class Notification {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String notificationId;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "userId")
    private UserAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "userId")
    private UserAccount receiver;
    private LocalDateTime sentAt;
}
