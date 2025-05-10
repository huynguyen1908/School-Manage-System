package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.TuitionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tuition")
@Data
public class Tuition {
    @Id
    @Column(name = "tuition_id")
    private String tuitionId;

    // Add this accessor method to handle camelCase references
    public String getTuitionId() {
        return tuitionId;
    }

    // Alternative accessor for snake_case
    public String getTuition_id() {
        return tuitionId;
    }

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TuitionStatus status;
}
