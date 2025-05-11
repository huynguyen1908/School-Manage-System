package org.example.dto.respone;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private String messageId;
    private String content;
    private String senderId;
    private String receiverId;
    private LocalDateTime sentAt;
}
