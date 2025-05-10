package org.example.service.impl;

import org.example.dto.request.CreateTuitionRequest;
import org.example.dto.request.PaymentRequest;
import org.example.dto.request.UpdateTuitionRequest;
import org.example.entity.Department;
import org.example.entity.Parent;
import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.example.repository.TuitionRepository;
import org.example.repository.ParentRepository;
import org.example.repository.DepartmentRepository;
import org.example.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class TuitionServiceImpl implements TuitionService {

    private final TuitionRepository repository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    public TuitionServiceImpl(TuitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tuition create(Tuition tuition) {
        tuition.setTuitionId(UUID.randomUUID().toString());
        tuition.setStatus(TuitionStatus.PENDING);
        return repository.save(tuition);
    }

    @Override
    public Optional<Tuition> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Tuition> getByParent(Parent parent) {
        return repository.findByParent(parent);
    }

    @Override
    public List<Tuition> getByStatus(TuitionStatus status) {
        return repository.findByStatus(status);
    }

    @Override
    public Tuition updateStatus(String id, TuitionStatus status) {
        Optional<Tuition> optional = repository.findById(id);
        if (optional.isPresent()) {
            Tuition tuition = optional.get();
            tuition.setStatus(status);
            return repository.save(tuition);
        }
        throw new RuntimeException("Tuition not found with id: " + id);
    }

    @Override
    public Tuition markAsPaid(String id, LocalDateTime paidAt) {
        Optional<Tuition> optional = repository.findById(id);
        if (optional.isPresent()) {
            Tuition tuition = optional.get();
            tuition.setPaidAt(paidAt);
            tuition.setStatus(TuitionStatus.PAID);
            return repository.save(tuition);
        }
        throw new RuntimeException("Tuition not found with id: " + id);
    }

    @Override
    public Tuition createTuition(CreateTuitionRequest request) {
        Tuition tuition = new Tuition();
        tuition.setTuitionId(UUID.randomUUID().toString());
        
        // Get Parent entity from parentId
        Parent parent = request.getParentId() != null ? 
            parentRepository.findById(request.getParentId())
                .orElseThrow(() -> new RuntimeException("Parent not found")) : null;
        tuition.setParent(parent);
        
        // Get Department entity from departmentId
        Department department = request.getDepartmentId() != null ?
            departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found")) : null;
        tuition.setDepartment(department);
        
        tuition.setAmount(request.getAmount());
        tuition.setDueDate(request.getDueDate());
        tuition.setStatus(TuitionStatus.PENDING);
        
        return repository.save(tuition);
    }

    @Override
    public List<Tuition> getAllTuitions(String parentId, TuitionStatus status) {
        if (parentId != null) {
            Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
            return repository.findByParent(parent);
        } else if (status != null) {
            return repository.findByStatus(status);
        }
        return repository.findAll();
    }

    @Override
    public Tuition getTuitionById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tuition not found with id: " + id));
    }

    @Override
    public Tuition updateTuition(String id, UpdateTuitionRequest request) {
        Tuition tuition = getTuitionById(id);

        if (request.getAmount() != null) {
            tuition.setAmount(request.getAmount());
        }

        if (request.getDueDate() != null) {
            tuition.setDueDate(request.getDueDate());
        }

        if (request.getStatus() != null) {
            tuition.setStatus(TuitionStatus.valueOf(request.getStatus()));
        }

        return repository.save(tuition);
    }

    @Override
    public Tuition processPayment(String id) {
        Tuition tuition = getTuitionById(id);
        tuition.setPaidAt(LocalDateTime.now());
        tuition.setStatus(TuitionStatus.PAID);
        return repository.save(tuition);
    }

    @Override
    public void deleteTuition(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Tuition> getOverdueTuitions() {
        return repository.findByDueDateBeforeAndStatusNot(
                LocalDate.now(), TuitionStatus.PAID);
    }

    @Override
    public Map<String, Object> getTuitionStatistics() {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalTuitions", repository.count());
        statistics.put("paidTuitions", repository.countByStatus(TuitionStatus.PAID));
        statistics.put("unpaidTuitions", repository.countByStatus(TuitionStatus.UNPAID));
        statistics.put("pendingTuitions", repository.countByStatus(TuitionStatus.PENDING));
        
        return statistics;
    }
}
