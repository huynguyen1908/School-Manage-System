package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.Subject;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "assignment")
public class Assignment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String assignmentId;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    private String title;
    private LocalDateTime dueDates;
    private String description;
}
