package org.example.repository;

import org.example.entity.Tuition;
import org.example.enums.TuitionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, String> {

    List<Tuition> findByParentParentId(String parentId);
    
    List<Tuition> findByStudentStudentId(String studentId);
    
    List<Tuition> findByStatus(TuitionStatus status);
    
    List<Tuition> findByDueDateBeforeAndStatusNot(LocalDate dueDate, TuitionStatus status);
    
    @Query("SELECT SUM(t.amount) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.semester = :semester")
    double sumAmountBySchoolYearAndSemester(@Param("schoolYear") String schoolYear, @Param("semester") String semester);
    
    @Query("SELECT SUM(t.amount) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.semester = :semester AND t.status = :status")
    double sumPaidAmountBySchoolYearAndSemester(
            @Param("schoolYear") String schoolYear, 
            @Param("semester") String semester, 
            @Param("status") TuitionStatus status);
    
    @Query("SELECT COUNT(t) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.semester = :semester")
    int countBySchoolYearAndSemester(@Param("schoolYear") String schoolYear, @Param("semester") String semester);
    
    @Query("SELECT COUNT(t) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.semester = :semester AND t.status = :status")
    int countPaidBySchoolYearAndSemester(
            @Param("schoolYear") String schoolYear, 
            @Param("semester") String semester, 
            @Param("status") TuitionStatus status);
    
    @Query("SELECT SUM(t.amount) FROM Tuition t WHERE t.schoolYear = :schoolYear")
    double sumAmountBySchoolYear(@Param("schoolYear") String schoolYear);
    
    @Query("SELECT SUM(t.amount) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.status = :status")
    double sumPaidAmountBySchoolYear(@Param("schoolYear") String schoolYear, @Param("status") TuitionStatus status);
    
    @Query("SELECT COUNT(t) FROM Tuition t WHERE t.schoolYear = :schoolYear")
    int countBySchoolYear(@Param("schoolYear") String schoolYear);
    
    @Query("SELECT COUNT(t) FROM Tuition t WHERE t.schoolYear = :schoolYear AND t.status = :status")
    int countPaidBySchoolYear(@Param("schoolYear") String schoolYear, @Param("status") TuitionStatus status);
    
    @Query("SELECT SUM(t.amount) FROM Tuition t")
    double sumTotalAmount();
    
    @Query("SELECT SUM(t.amount) FROM Tuition t WHERE t.status = :status")
    double sumPaidAmount(@Param("status") TuitionStatus status);
    
    int countByStatus(TuitionStatus status);
}
