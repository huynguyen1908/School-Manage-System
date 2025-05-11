package org.example.dto.request;

import lombok.Data;

@Data
public class CreateMessageRequest {
    private String sender;
    private String receiver;
    private String content;
}
