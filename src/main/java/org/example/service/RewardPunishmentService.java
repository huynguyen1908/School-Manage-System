package org.example.service;

import org.example.dto.request.CreateRewardPunishmentRequest;
import org.example.dto.request.UpdateRewardPunishmentRequest;
import org.example.entity.Department;
import org.example.entity.RewardPunishment;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;
import org.example.repository.DepartmentRepository;
import org.example.repository.RewardPunishmentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardPunishmentService {

    @Autowired
    private RewardPunishmentRepository rewardPunishmentRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private NotificationService notificationService;

    @Transactional
    public RewardPunishment createRewardPunishment(CreateRewardPunishmentRequest request) {
        RewardPunishment rewardPunishment = new RewardPunishment();
        
        // Set department that decided the reward/punishment
        Department department = departmentRepository.findById(request.getDecidedById())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        rewardPunishment.setDecidedBy(department);
        
        // Set student if provided
        if (request.getStudentId() != null) {
            Student student = studentRepository.findById(request.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            rewardPunishment.setStudent(student);
        }
        
        // Set teacher if provided
        if (request.getTeacherId() != null) {
            Teacher teacher = teacherRepository.findById(request.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));
            rewardPunishment.setTeacher(teacher);
        }
        
        rewardPunishment.setContent(request.getContent());
        rewardPunishment.setDescription(request.getDescription());
        rewardPunishment.setSentAt(LocalDateTime.now());
        rewardPunishment.setEffectiveDate(request.getEffectiveDate());
        rewardPunishment.setStatus(RewardPunishmentStatus.valueOf(request.getStatus()));
        rewardPunishment.setType(RewardPunishmentType.valueOf(request.getType()));
        
        RewardPunishment savedRP = rewardPunishmentRepository.save(rewardPunishment);
        
        return savedRP;
    }

    public List<RewardPunishment> getAllRewardPunishments(String studentId, String type, String status) {
        if (studentId != null) {
            return rewardPunishmentRepository.findByStudentStudentId(studentId);
        } else if (type != null && status != null) {
            return rewardPunishmentRepository.findByTypeAndStatus(
                    RewardPunishmentType.valueOf(type), 
                    RewardPunishmentStatus.valueOf(status));
        } else if (type != null) {
            return rewardPunishmentRepository.findByType(RewardPunishmentType.valueOf(type));
        } else if (status != null) {
            return rewardPunishmentRepository.findByStatus(RewardPunishmentStatus.valueOf(status));
        }
        return rewardPunishmentRepository.findAll();
    }

    public RewardPunishment getRewardPunishmentById(String id) {
        return rewardPunishmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reward/Punishment not found with id: " + id));
    }

    @Transactional
    public RewardPunishment updateRewardPunishment(String id, UpdateRewardPunishmentRequest request) {
        RewardPunishment rewardPunishment = getRewardPunishmentById(id);
        
        if (request.getContent() != null) {
            rewardPunishment.setContent(request.getContent());
        }
        
        if (request.getDescription() != null) {
            rewardPunishment.setDescription(request.getDescription());
        }
        
        if (request.getStatus() != null) {
            rewardPunishment.setStatus(RewardPunishmentStatus.valueOf(request.getStatus()));
        }
        
        if (request.getEffectiveDate() != null) {
            rewardPunishment.setEffectiveDate(request.getEffectiveDate());
        }
        
        return rewardPunishmentRepository.save(rewardPunishment);
    }

    @Transactional
    public void deleteRewardPunishment(String id) {
        RewardPunishment rewardPunishment = getRewardPunishmentById(id);
        rewardPunishmentRepository.delete(rewardPunishment);
    }

    @Transactional
    public RewardPunishment sendNotification(String id) {
        RewardPunishment rewardPunishment = getRewardPunishmentById(id);
        
        if (!rewardPunishment.isNotificationSent()) {
            rewardPunishment.markNotificationSent();
            rewardPunishmentRepository.save(rewardPunishment);
            
            // Send notification to student and parent
            notificationService.sendRewardPunishmentNotification(rewardPunishment);
        }
        
        return rewardPunishment;
    }

    @Transactional
    public RewardPunishment acknowledgeByParent(String id) {
        RewardPunishment rewardPunishment = getRewardPunishmentById(id);
        
        if (!rewardPunishment.isParentAcknowledged()) {
            rewardPunishment.acknowledgeByParent();
            rewardPunishmentRepository.save(rewardPunishment);
        }
        
        return rewardPunishment;
    }

    @Transactional
    public RewardPunishment addParentFeedback(String id, String feedback) {
        RewardPunishment rewardPunishment = getRewardPunishmentById(id);
        
        rewardPunishment.addParentFeedback(feedback);
        return rewardPunishmentRepository.save(rewardPunishment);
    }

    public Object getStatistics(String studentId, String classId, String timeFrame) {
        Map<String, Object> statistics = new HashMap<>();
        
        if (studentId != null) {
            // Get statistics for a specific student
            long rewardCount = rewardPunishmentRepository.countByStudentStudentIdAndType(
                    studentId, RewardPunishmentType.REWARD);
            long punishmentCount = rewardPunishmentRepository.countByStudentStudentIdAndType(
                    studentId, RewardPunishmentType.PUNISHMENT);
            
            statistics.put("studentId", studentId);
            statistics.put("rewardCount", rewardCount);
            statistics.put("punishmentCount", punishmentCount);
            
            // Add student details if needed
            Student student = studentRepository.findById(studentId).orElse(null);
            if (student != null) {
                statistics.put("studentName", student.getFullName());
                statistics.put("className", student.getClassroom() != null ? student.getClassroom().getClassName() : null);
            }
        } else if (classId != null) {
            // Get statistics for a specific class
            long rewardCount = rewardPunishmentRepository.countByStudentClassroomClassIdAndType(
                    classId, RewardPunishmentType.REWARD);
            long punishmentCount = rewardPunishmentRepository.countByStudentClassroomClassIdAndType(
                    classId, RewardPunishmentType.PUNISHMENT);
            
            statistics.put("classId", classId);
            statistics.put("rewardCount", rewardCount);
            statistics.put("punishmentCount", punishmentCount);
        } else {
            // Get overall statistics
            long rewardCount = rewardPunishmentRepository.countByType(RewardPunishmentType.REWARD);
            long punishmentCount = rewardPunishmentRepository.countByType(RewardPunishmentType.PUNISHMENT);
            
            statistics.put("totalRewards", rewardCount);
            statistics.put("totalPunishments", punishmentCount);
        }
        
        // Add time-based filtering if needed
        if (timeFrame != null) {
            LocalDateTime startDate;
            LocalDateTime now = LocalDateTime.now();
            
            switch (timeFrame) {
                case "week":
                    startDate = now.minusWeeks(1);
                    break;
                case "month":
                    startDate = now.minusMonths(1);
                    break;
                case "semester":
                    startDate = now.minusMonths(6);
                    break;
                case "year":
                    startDate = now.minusYears(1);
                    break;
                default:
                    startDate = now.minusMonths(3); // Default to 3 months
            }
            
            if (studentId != null) {
                long recentRewards = rewardPunishmentRepository.countByStudentStudentIdAndTypeAndSentAtAfter(
                        studentId, RewardPunishmentType.REWARD, startDate);
                long recentPunishments = rewardPunishmentRepository.countByStudentStudentIdAndTypeAndSentAtAfter(
                        studentId, RewardPunishmentType.PUNISHMENT, startDate);
                
                statistics.put("recentRewards", recentRewards);
                statistics.put("recentPunishments", recentPunishments);
            } else {
                long recentRewards = rewardPunishmentRepository.countByTypeAndSentAtAfter(
                        RewardPunishmentType.REWARD, startDate);
                long recentPunishments = rewardPunishmentRepository.countByTypeAndSentAtAfter(
                        RewardPunishmentType.PUNISHMENT, startDate);
                
                statistics.put("recentRewards", recentRewards);
                statistics.put("recentPunishments", recentPunishments);
            }
        }
        
        return statistics;
    }
}
