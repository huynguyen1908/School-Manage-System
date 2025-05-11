package org.example.controller;

import org.example.dto.request.CreateRewardPunishmentRequest;
import org.example.dto.respone.RewardPunishmentDTO;
import org.example.entity.RewardPunishment;
import org.example.service.RewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RewardPunishmentController {

    @Autowired
    private RewardPunishmentService rewardPunishmentService;

    @PostMapping("/rewards")
    public ResponseEntity<RewardPunishment> createReward(@RequestBody CreateRewardPunishmentRequest request) {
        RewardPunishment rewardPunishment = rewardPunishmentService.createReward(request);
        return ResponseEntity.ok(rewardPunishment);
    }

    @PostMapping("/punishments")
    public ResponseEntity<RewardPunishment> createPunishment(@RequestBody CreateRewardPunishmentRequest request) {
        RewardPunishment rewardPunishment = rewardPunishmentService.createPunishment(request);
        return ResponseEntity.ok(rewardPunishment);
    }

    @GetMapping("/rewards/getList")
    public ResponseEntity<List<RewardPunishmentDTO>> getRewardList() {
        List<RewardPunishmentDTO> rewardList = rewardPunishmentService.getRewardList();
        return ResponseEntity.ok(rewardList);
    }

    @GetMapping("/rewards/{rpId}")
    public ResponseEntity<RewardPunishmentDTO> getRewardById(@PathVariable("rpId") String rpId) {
        RewardPunishmentDTO reward = rewardPunishmentService.getRewardById(rpId);
        return ResponseEntity.ok(reward);
    }

    @GetMapping("/punishments/getList")
    public ResponseEntity<List<RewardPunishmentDTO>> getPunishmentList() {
        List<RewardPunishmentDTO> punishmentList = rewardPunishmentService.getPunishmentList();
        return ResponseEntity.ok(punishmentList);

    }
    @GetMapping("/punishments/{rpId}")
    public ResponseEntity<RewardPunishmentDTO> getPunishmentById(@PathVariable("rpId") String rpId) {
        RewardPunishmentDTO punishment = rewardPunishmentService.getPunishmentById(rpId);
        return ResponseEntity.ok(punishment);
    }
}
