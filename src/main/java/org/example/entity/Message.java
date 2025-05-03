package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Data
public class Message {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String messageId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "userId")
    private UserAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "userId")
    private UserAccount receiver;

    private String content;
    private LocalDateTime sentAt;
}
