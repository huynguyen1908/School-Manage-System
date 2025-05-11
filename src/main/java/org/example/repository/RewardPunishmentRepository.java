package org.example.repository;

import org.example.entity.RewardPunishment;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RewardPunishmentRepository extends JpaRepository<RewardPunishment, String> {
    List<RewardPunishment> findByType(RewardPunishmentType type);
}
