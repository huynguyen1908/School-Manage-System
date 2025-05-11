package org.example.dto.request;

import lombok.Data;

@Data
public class CreateFeedbackDTO {
    private String senderId;
    private String receiverId;
    private String content;
}
