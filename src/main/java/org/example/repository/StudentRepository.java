package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    @Query("SELECT s FROM Student s JOIN s.parent p WHERE p.parentId = :parentId")
    List<Student> findByParentId(@Param("parentId") String parentId);
}
