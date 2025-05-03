package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.Subject;

@Entity
@Data
@Table(name = "study_score")
public class StudyScore {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String scoreId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;
    private String semester;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    private Double score;
}
