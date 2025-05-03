package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.RequestStatus;
import org.example.enums.RequestType;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "request_feedback")
public class RequestFeedback {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String rfId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "userId")
    private UserAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "userId")
    private UserAccount receiver;

    private String content;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    private LocalDateTime sendAt;
}
