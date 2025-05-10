package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "tuition_id") // Xóa referencedColumnName để sử dụng khóa chính mặc định
    private Tuition tuition;

    private BigDecimal amount;
    
    private String paymentMethod;
    
    private String transactionId;
    
    private LocalDateTime paidAt;
    
    private String status;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
