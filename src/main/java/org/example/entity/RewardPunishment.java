package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.RewardPunishmentStatus;
import org.example.enums.RewardPunishmentType;

import java.time.LocalDateTime;

@Entity
@Table(name = "reward_punishment")
@Data
public class RewardPunishment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rpId;

    @ManyToOne
    @JoinColumn(name = "decided_by_id", referencedColumnName = "departmentId")
    private Department decidedBy;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    private String content;
    private LocalDateTime sentAt;
    
    @Column(name = "effective_date")
    private LocalDateTime effectiveDate;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "notification_sent")
    private boolean notificationSent;
    
    @Column(name = "parent_acknowledged")
    private boolean parentAcknowledged;
    
    @Column(name = "parent_feedback", columnDefinition = "TEXT")
    private String parentFeedback;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private RewardPunishmentStatus status;

    @Enumerated(EnumType.STRING)
    private RewardPunishmentType type;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (sentAt == null) {
            sentAt = LocalDateTime.now();
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Method to mark notification as sent
    public void markNotificationSent() {
        this.notificationSent = true;
    }
    
    // Method to acknowledge receipt by parent
    public void acknowledgeByParent() {
        this.parentAcknowledged = true;
    }
    
    // Method to add feedback from parent
    public void addParentFeedback(String feedback) {
        this.parentFeedback = feedback;
    }
}