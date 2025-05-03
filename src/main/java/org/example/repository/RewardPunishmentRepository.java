package org.example.repository;

import org.example.entity.RewardPunishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardPunishmentRepository extends JpaRepository<RewardPunishment, String> {
}
