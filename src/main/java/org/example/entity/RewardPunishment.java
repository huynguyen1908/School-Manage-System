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
    @Enumerated(EnumType.STRING)
    private RewardPunishmentStatus status;

}