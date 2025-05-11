package org.example.dto.respone;

import lombok.Data;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;

import java.time.LocalDateTime;

@Data
public class RewardPunishmentDTO {
    private String rpId;
    private String studentId;
    private String teacherId;
    private String content;
    private LocalDateTime sentAt;
    private RewardPunishmentType type;
    private RewardPunishmentStatus status;
}
