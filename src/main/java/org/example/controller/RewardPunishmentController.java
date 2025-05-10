package org.example.controller;

import org.example.entity.RewardPunishment;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;
import org.example.service.RewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reward-punishment")
public class RewardPunishmentController {
    
    private final RewardPunishmentService service;
    
    @Autowired
    public RewardPunishmentController(RewardPunishmentService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<RewardPunishment> create(@RequestBody RewardPunishment rewardPunishment) {
        return new ResponseEntity<>(service.create(rewardPunishment), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RewardPunishment> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/type/{type}")
    public ResponseEntity<List<RewardPunishment>> getByType(@PathVariable RewardPunishmentType type) {
        return ResponseEntity.ok(service.getByType(type));
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<RewardPunishment>> getByStatus(@PathVariable RewardPunishmentStatus status) {
        return ResponseEntity.ok(service.getByStatus(status));
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<RewardPunishment> updateStatus(
            @PathVariable String id, 
            @RequestParam RewardPunishmentStatus status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }
}
