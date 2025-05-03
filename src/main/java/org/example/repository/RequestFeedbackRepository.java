package org.example.repository;

import org.example.entity.RequestFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestFeedbackRepository extends JpaRepository<RequestFeedback, String> {
}
