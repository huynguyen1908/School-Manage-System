package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.Subject;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "assignment")
public class Assignment {
    @Id
    @Column(name = "assignment_id")
    private String assignmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @OneToMany
    @JoinColumn(name = "class_id", referencedColumnName = "classId")
    private Classes classes;

    @Column(name = "title")
    private String title;
    
    @Column(name = "due_dates")
    private LocalDateTime dueDates;
    
    @Column(name = "description")
    private String description;
}
