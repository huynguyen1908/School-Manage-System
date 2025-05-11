package org.example.repository;

import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    Optional<Department> findByUser(UserAccount userAccount);
}
