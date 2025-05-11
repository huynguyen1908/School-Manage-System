package org.example.service;

import org.example.dto.request.CreateRewardPunishmentRequest;
import org.example.dto.respone.RewardPunishmentDTO;
import org.example.entity.RewardPunishment;

import java.util.List;

public interface RewardPunishmentService {
    RewardPunishment createReward(CreateRewardPunishmentRequest request);
    RewardPunishment createPunishment(CreateRewardPunishmentRequest request);
    List<RewardPunishmentDTO> getRewardList();
    RewardPunishmentDTO getRewardById(String id);
    List<RewardPunishmentDTO> getPunishmentList();
    RewardPunishmentDTO getPunishmentById(String id);

}
