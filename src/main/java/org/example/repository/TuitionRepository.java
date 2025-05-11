package org.example.repository;

import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, String> {
    List<Tuition> findByStudent_StudentId(String studentId);
    Optional<Tuition> findByTuitionId(String tuitionId);


}
