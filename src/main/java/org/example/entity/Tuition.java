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
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "school_year")
    private String schoolYear;
    
    @Column(name = "late_fee")
    private BigDecimal lateFee;
    
    @Column(name = "notification_sent")
    private boolean notificationSent;
    
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @Column(name = "transaction_id")
    private String transactionId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Method to mark as paid
    public void markAsPaid(String method, String transactionId) {
        this.paymentMethod = method;
        this.transactionId = transactionId;
        this.paidAt = LocalDateTime.now();
        this.status = TuitionStatus.PAID;
    }
    
    // Method to calculate if payment is late
    public boolean isLate() {
        return LocalDate.now().isAfter(dueDate) && 
               status != TuitionStatus.PAID;
    }
    
    // Method to send notification
    public void markNotificationSent() {
        this.notificationSent = true;
    }
}
