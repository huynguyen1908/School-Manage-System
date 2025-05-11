package org.example.repository;

import org.example.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    List<Assignment> findByTeacher_TeacherId(String teacherId);
    @Query("SELECT a FROM Assignment a WHERE a.teacher.teacherId = :teacherId")
    List<Assignment> findByTeacherId(@Param("teacherId") String teacherId);
}
