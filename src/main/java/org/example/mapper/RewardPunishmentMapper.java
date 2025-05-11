package org.example.mapper;

import org.example.dto.respone.RewardPunishmentDTO;
import org.example.entity.RewardPunishment;

public class RewardPunishmentMapper {
    public static RewardPunishmentDTO toDTO(RewardPunishment rp) {
        RewardPunishmentDTO dto = new RewardPunishmentDTO();
        dto.setRpId(rp.getRpId());
        dto.setStudentId(rp.getStudent().getStudentId());
        dto.setTeacherId(rp.getTeacher().getTeacherId());
        dto.setContent(rp.getContent());
        dto.setSentAt(rp.getSentAt());
        dto.setType(rp.getType());
        dto.setStatus(rp.getStatus());
        return dto;
    }
}
