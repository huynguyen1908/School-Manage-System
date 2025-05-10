package org.example.service;

import org.example.entity.RewardPunishment;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;

import java.util.List;
import java.util.Optional;

public interface RewardPunishmentService {
    RewardPunishment create(RewardPunishment rewardPunishment);
    Optional<RewardPunishment> getById(String id);
    List<RewardPunishment> getByStudent(Student student);
    List<RewardPunishment> getByTeacher(Teacher teacher);
    List<RewardPunishment> getByType(RewardPunishmentType type);
    List<RewardPunishment> getByStatus(RewardPunishmentStatus status);
    RewardPunishment updateStatus(String id, RewardPunishmentStatus status);
}
