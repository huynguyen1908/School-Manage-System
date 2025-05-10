package org.example.repository;

import org.example.entity.RewardPunishment;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RewardPunishmentRepository extends JpaRepository<RewardPunishment, String> {

    List<RewardPunishment> findByStudentStudentId(String studentId);
    
    List<RewardPunishment> findByTypeAndStatus(RewardPunishmentType type, RewardPunishmentStatus status);
    
    List<RewardPunishment> findByType(RewardPunishmentType type);
    
    List<RewardPunishment> findByStatus(RewardPunishmentStatus status);
    
    long countByStudentStudentIdAndType(String studentId, RewardPunishmentType type);
    
    @Query("SELECT COUNT(rp) FROM RewardPunishment rp WHERE rp.student.classroom.classId = :classId AND rp.type = :type")
    long countByStudentClassroomClassIdAndType(
            @Param("classId") String classId, 
            @Param("type") RewardPunishmentType type);
    
    long countByType(RewardPunishmentType type);
    
    @Query("SELECT COUNT(rp) FROM RewardPunishment rp WHERE rp.student.studentId = :studentId AND rp.type = :type AND rp.sentAt > :date")
    long countByStudentStudentIdAndTypeAndSentAtAfter(
            @Param("studentId") String studentId, 
            @Param("type") RewardPunishmentType type,
            @Param("date") LocalDateTime date);
    
    @Query("SELECT COUNT(rp) FROM RewardPunishment rp WHERE rp.type = :type AND rp.sentAt > :date")
    long countByTypeAndSentAtAfter(
            @Param("type") RewardPunishmentType type,
            @Param("date") LocalDateTime date);
    
    // Add methods for more advanced statistics if needed
    @Query("SELECT COUNT(rp) FROM RewardPunishment rp WHERE rp.student.studentId = :studentId AND rp.sentAt BETWEEN :startDate AND :endDate")
    long countByStudentIdAndDateRange(
            @Param("studentId") String studentId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT COUNT(rp) FROM RewardPunishment rp WHERE rp.student.classroom.classId = :classId AND rp.type = :type AND rp.sentAt > :date")
    long countByClassIdAndTypeAndSentAtAfter(
            @Param("classId") String classId,
            @Param("type") RewardPunishmentType type,
            @Param("date") LocalDateTime date);
}
