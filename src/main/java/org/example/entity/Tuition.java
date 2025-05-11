package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.TuitionStatus;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tuition")
@Data
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String tuitionId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "parentId")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    private String departmentId;

    private LocalDate dueDate;

    private LocalDateTime paidAt;

    @Enumerated(EnumType.STRING)
    private TuitionStatus status;

    private BigDecimal amount;
}
