package org.example.dto.request;

import lombok.Data;

@Data
public class CreateRequestDTO {
    private String senderId;
    private String receiverId;
    private String content;
}
