package org.example.repository;

import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, String> {
}
