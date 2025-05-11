package org.example.repository;

import org.example.entity.RequestFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestFeedbackRepository extends JpaRepository<RequestFeedback, String> {
    List<RequestFeedback> findBySender_UserId(String userId);
}
