package org.example.service.impl;

import org.example.entity.RewardPunishment;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;
import org.example.repository.RewardPunishmentRepository;
import org.example.service.RewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RewardPunishmentServiceImpl implements RewardPunishmentService {

    private final RewardPunishmentRepository repository;

    public RewardPunishmentServiceImpl(RewardPunishmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RewardPunishment create(RewardPunishment rewardPunishment) {
        rewardPunishment.setRpId(UUID.randomUUID().toString());
        rewardPunishment.setSentAt(LocalDateTime.now());
        rewardPunishment.setStatus(RewardPunishmentStatus.PENDING);
        return repository.save(rewardPunishment);
    }

    @Override
    public Optional<RewardPunishment> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<RewardPunishment> getByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public List<RewardPunishment> getByTeacher(Teacher teacher) {
        return repository.findByTeacher(teacher);
    }

    @Override
    public List<RewardPunishment> getByType(RewardPunishmentType type) {
        return repository.findByType(type);
    }

    @Override
    public List<RewardPunishment> getByStatus(RewardPunishmentStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public RewardPunishment updateStatus(String id, RewardPunishmentStatus status) {
        Optional<RewardPunishment> optional = repository.findById(id);
        if (optional.isPresent()) {
            RewardPunishment rewardPunishment = optional.get();
            rewardPunishment.setStatus(status);
            return repository.save(rewardPunishment);
        }
        throw new RuntimeException("Reward/Punishment not found with id: " + id);
    }
}
