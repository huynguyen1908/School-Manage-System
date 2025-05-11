package org.example.dto.request;

import lombok.Data;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;

import java.time.LocalDateTime;

@Data
public class CreateRewardPunishmentRequest {
    private String departmentId;
    private String studentId;
    private String teacherId;
    private String content;
    private RewardPunishmentType type ;
    private RewardPunishmentStatus status ;
    private LocalDateTime sentAt = LocalDateTime.now();  // Default to current time
}
