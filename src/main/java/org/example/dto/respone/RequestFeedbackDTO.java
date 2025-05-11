package org.example.dto.respone;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RequestFeedbackDTO {
    private String rfId;
    private String senderId;
    private String receiverId;
    private String content;
    private String status;
    private String type;
    private LocalDateTime sendAt;
}
