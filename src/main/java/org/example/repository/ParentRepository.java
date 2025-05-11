package org.example.repository;

import org.example.entity.Parent;
import org.example.entity.Student;
import org.example.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String> {
    Optional<Parent> findByUser(UserAccount userAccount);
    @Query("SELECT p FROM Parent p JOIN Student s ON s.parent = p WHERE s.studentId = :studentId")
    Optional<Parent> findByStudentId(@Param("studentId") String studentId);

}
