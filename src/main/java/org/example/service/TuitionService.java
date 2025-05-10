package org.example.service;

import org.example.dto.request.CreateTuitionRequest;
import org.example.dto.request.UpdateTuitionRequest;
import org.example.entity.Parent;
import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TuitionService {
    Tuition create(Tuition tuition);
    Optional<Tuition> getById(String id);
    List<Tuition> getByParent(Parent parent);
    List<Tuition> getByStatus(TuitionStatus status);
    Tuition updateStatus(String id, TuitionStatus status);
    Tuition markAsPaid(String id, LocalDateTime paidAt);
    Tuition createTuition(CreateTuitionRequest request);
    List<Tuition> getAllTuitions(String parentId, TuitionStatus status);
    Tuition getTuitionById(String id);
    Tuition updateTuition(String id, UpdateTuitionRequest request);
    Tuition processPayment(String id);
    void deleteTuition(String id);
    List<Tuition> getOverdueTuitions();
    Map<String, Object> getTuitionStatistics();
}
