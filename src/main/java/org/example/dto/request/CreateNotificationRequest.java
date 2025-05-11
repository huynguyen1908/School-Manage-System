package org.example.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateNotificationRequest {
     String title;
     String content;
     String sender;
     String receiver;
}
