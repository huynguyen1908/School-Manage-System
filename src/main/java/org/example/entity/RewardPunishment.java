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
    @Column(name = "rp_id")
    private String rpId;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    @ManyToOne
    @JoinColumn(name = "decided_by_id")
    private Department decidedBy;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "sent_at")
    private LocalDateTime sentAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RewardPunishmentStatus status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RewardPunishmentType type;
}