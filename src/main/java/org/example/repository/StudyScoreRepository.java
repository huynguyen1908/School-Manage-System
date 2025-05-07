package org.example.repository;

import org.example.entity.StudyScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyScoreRepository extends JpaRepository<StudyScore, String> {
    List<StudyScore> findByStudent_StudentId(String studentId);
}
