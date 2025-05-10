package org.example.service;

import org.example.entity.RewardPunishment;
import org.example.entity.Tuition;
import org.springframework.stereotype.Service;

public interface NotificationService {
    void sendRewardPunishmentNotification(RewardPunishment rewardPunishment);
    void sendTuitionReminder(Tuition tuition);
}
