package org.example.service;

import org.example.dto.request.CreateTuitionRequest;
import org.example.dto.request.PayTuitionRequest;
import org.example.dto.request.UpdateTuitionRequest;
import org.example.entity.Parent;
import org.example.entity.Student;
import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.example.repository.ParentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;
    
    @Autowired
    private ParentRepository parentRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private NotificationService notificationService;

    @Transactional
    public Tuition createTuition(CreateTuitionRequest request) {
        Parent parent = parentRepository.findById(request.getParentId())
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        
        Tuition tuition = new Tuition();
        tuition.setParent(parent);
        tuition.setDepartmentId(request.getDepartmentId());
        tuition.setDueDate(request.getDueDate());
        tuition.setAmount(request.getAmount());
        tuition.setStatus(TuitionStatus.PENDING);
        
        // Set additional fields if present in request
        if (request.getStudentId() != null) {
            Student student = studentRepository.findById(request.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            tuition.setStudent(student);
        }
        
        if (request.getSemester() != null) {
            tuition.setSemester(request.getSemester());
        }
        
        if (request.getSchoolYear() != null) {
            tuition.setSchoolYear(request.getSchoolYear());
        }
        
        if (request.getDescription() != null) {
            tuition.setDescription(request.getDescription());
        }
        
        Tuition savedTuition = tuitionRepository.save(tuition);
        
        // Send notification to parent
        notificationService.sendTuitionNotification(savedTuition);
        
        return savedTuition;
    }

    public List<Tuition> getAllTuitions(String parentId, String studentId, String status) {
        if (parentId != null) {
            return tuitionRepository.findByParentParentId(parentId);
        } else if (studentId != null) {
            return tuitionRepository.findByStudentStudentId(studentId);
        } else if (status != null) {
            return tuitionRepository.findByStatus(TuitionStatus.valueOf(status));
        }
        return tuitionRepository.findAll();
    }

    public Tuition getTuitionById(String id) {
        return tuitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tuition not found with id: " + id));
    }

    @Transactional
    public Tuition updateTuition(String id, UpdateTuitionRequest request) {
        Tuition tuition = getTuitionById(id);
        
        if (request.getDueDate() != null) {
            tuition.setDueDate(request.getDueDate());
        }
        
        if (request.getAmount() != null) {
            tuition.setAmount(request.getAmount());
        }
        
        if (request.getStatus() != null) {
            tuition.setStatus(TuitionStatus.valueOf(request.getStatus()));
        }
        
        if (request.getDescription() != null) {
            tuition.setDescription(request.getDescription());
        }
        
        if (request.getSemester() != null) {
            tuition.setSemester(request.getSemester());
        }
        
        if (request.getSchoolYear() != null) {
            tuition.setSchoolYear(request.getSchoolYear());
        }
        
        return tuitionRepository.save(tuition);
    }

    @Transactional
    public Tuition recordPayment(String id, PayTuitionRequest request) {
        Tuition tuition = getTuitionById(id);
        tuition.setStatus(TuitionStatus.PAID);
        tuition.setPaidAt(LocalDateTime.now());
        tuition.setPaymentMethod(request.getPaymentMethod());
        tuition.setTransactionId(request.getTransactionId());
        
        Tuition paidTuition = tuitionRepository.save(tuition);
        
        // Send payment confirmation notification
        notificationService.sendPaymentConfirmation(paidTuition);
        
        return paidTuition;
    }

    @Transactional
    public Tuition sendPaymentReminder(String id) {
        Tuition tuition = getTuitionById(id);
        
        if (tuition.getStatus() != TuitionStatus.PAID) {
            // Mark notification as sent
            tuition.setNotificationSent(true);
            tuitionRepository.save(tuition);
            
            // Send reminder notification
            notificationService.sendPaymentReminder(tuition);
        }
        
        return tuition;
    }

    @Transactional
    public void deleteTuition(String id) {
        Tuition tuition = getTuitionById(id);
        tuitionRepository.delete(tuition);
    }

    public List<Tuition> getOverdueTuitions() {
        LocalDate now = LocalDate.now();
        return tuitionRepository.findByDueDateBeforeAndStatusNot(now, TuitionStatus.PAID);
    }

    public Map<String, Object> getTuitionStatistics(String schoolYear, String semester) {
        Map<String, Object> statistics = new HashMap<>();
        
        if (schoolYear != null && semester != null) {
            double totalAmount = tuitionRepository.sumAmountBySchoolYearAndSemester(schoolYear, semester);
            double paidAmount = tuitionRepository.sumPaidAmountBySchoolYearAndSemester(schoolYear, semester, TuitionStatus.PAID);
            int totalCount = tuitionRepository.countBySchoolYearAndSemester(schoolYear, semester);
            int paidCount = tuitionRepository.countPaidBySchoolYearAndSemester(schoolYear, semester, TuitionStatus.PAID);
            
            statistics.put("totalAmount", totalAmount);
            statistics.put("paidAmount", paidAmount);
            statistics.put("totalCount", totalCount);
            statistics.put("paidCount", paidCount);
            statistics.put("paymentRate", totalCount > 0 ? (double) paidCount / totalCount : 0);
        } else if (schoolYear != null) {
            double totalAmount = tuitionRepository.sumAmountBySchoolYear(schoolYear);
            double paidAmount = tuitionRepository.sumPaidAmountBySchoolYear(schoolYear, TuitionStatus.PAID);
            int totalCount = tuitionRepository.countBySchoolYear(schoolYear);
            int paidCount = tuitionRepository.countPaidBySchoolYear(schoolYear, TuitionStatus.PAID);
            
            statistics.put("totalAmount", totalAmount);
            statistics.put("paidAmount", paidAmount);
            statistics.put("totalCount", totalCount);
            statistics.put("paidCount", paidCount);
            statistics.put("paymentRate", totalCount > 0 ? (double) paidCount / totalCount : 0);
        } else {
            // Get overall statistics
            double totalAmount = tuitionRepository.sumTotalAmount();
            double paidAmount = tuitionRepository.sumPaidAmount(TuitionStatus.PAID);
            int totalCount = (int) tuitionRepository.count();
            int paidCount = tuitionRepository.countByStatus(TuitionStatus.PAID);
            
            statistics.put("totalAmount", totalAmount);
            statistics.put("paidAmount", paidAmount);
            statistics.put("totalCount", totalCount);
            statistics.put("paidCount", paidCount);
            statistics.put("paymentRate", totalCount > 0 ? (double) paidCount / totalCount : 0);
        }
        
        return statistics;
    }

    @Transactional
    public int sendBulkReminders() {
        List<Tuition> overdueTuitions = getOverdueTuitions();
        
        for (Tuition tuition : overdueTuitions) {
            if (!tuition.isNotificationSent()) {
                tuition.setNotificationSent(true);
                tuitionRepository.save(tuition);
                notificationService.sendPaymentReminder(tuition);
            }
        }
        
        return overdueTuitions.size();
    }
}
