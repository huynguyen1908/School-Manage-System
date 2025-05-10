package org.example.repository;

import org.example.entity.Parent;
import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, String> {
    List<Tuition> findByParent(Parent parent);
    List<Tuition> findByParentParentId(String parentId);
    List<Tuition> findByStatus(TuitionStatus status);
    List<Tuition> findByDueDateBeforeAndStatusNot(LocalDate date, TuitionStatus status);
    long countByStatus(TuitionStatus status);
}
