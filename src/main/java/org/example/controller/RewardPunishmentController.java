package org.example.controller;

import org.example.dto.request.CreateRewardPunishmentRequest;
import org.example.dto.request.UpdateRewardPunishmentRequest;
import org.example.dto.request.ParentFeedbackRequest;
import org.example.entity.RewardPunishment;
import org.example.service.RewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards-punishments")
public class RewardPunishmentController {
    
    @Autowired
    private RewardPunishmentService rewardPunishmentService;
    
    @PostMapping
    public ResponseEntity<RewardPunishment> createRewardPunishment(@RequestBody CreateRewardPunishmentRequest request) {
        RewardPunishment rewardPunishment = rewardPunishmentService.createRewardPunishment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(rewardPunishment);
    }
    
    @GetMapping
    public ResponseEntity<List<RewardPunishment>> getAllRewardPunishments(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String status) {
        List<RewardPunishment> rewards = rewardPunishmentService.getAllRewardPunishments(studentId, type, status);
        return ResponseEntity.ok(rewards);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RewardPunishment> getRewardPunishmentById(@PathVariable String id) {
        RewardPunishment reward = rewardPunishmentService.getRewardPunishmentById(id);
        return ResponseEntity.ok(reward);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RewardPunishment> updateRewardPunishment(
            @PathVariable String id, 
            @RequestBody UpdateRewardPunishmentRequest request) {
        RewardPunishment updatedReward = rewardPunishmentService.updateRewardPunishment(id, request);
        return ResponseEntity.ok(updatedReward);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRewardPunishment(@PathVariable String id) {
        rewardPunishmentService.deleteRewardPunishment(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/send-notification")
    public ResponseEntity<RewardPunishment> sendNotification(@PathVariable String id) {
        RewardPunishment reward = rewardPunishmentService.sendNotification(id);
        return ResponseEntity.ok(reward);
    }
    
    @PostMapping("/{id}/acknowledge")
    public ResponseEntity<RewardPunishment> acknowledgeByParent(@PathVariable String id) {
        RewardPunishment reward = rewardPunishmentService.acknowledgeByParent(id);
        return ResponseEntity.ok(reward);
    }
    
    @PostMapping("/{id}/feedback")
    public ResponseEntity<RewardPunishment> addParentFeedback(
            @PathVariable String id, 
            @RequestBody ParentFeedbackRequest request) {
        RewardPunishment reward = rewardPunishmentService.addParentFeedback(id, request.getFeedback());
        return ResponseEntity.ok(reward);
    }
    
    @GetMapping("/statistics")
    public ResponseEntity<?> getStatistics(
            @RequestParam(required = false) String studentId,
            @RequestParam(required = false) String classId,
            @RequestParam(required = false) String timeFrame) {
        Object statistics = rewardPunishmentService.getStatistics(studentId, classId, timeFrame);
        return ResponseEntity.ok(statistics);
    }
}
