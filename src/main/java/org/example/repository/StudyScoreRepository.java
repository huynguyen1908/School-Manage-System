package org.example.repository;

import org.example.entity.StudyScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyScoreRepository extends JpaRepository<StudyScore, String> {
}
