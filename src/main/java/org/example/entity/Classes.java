package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "classes")
public class Classes {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String classId;
    private String className;
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")
    private Assignment assignment;

    @OneToOne
    @JoinColumn(name = "homeroomTeacherId", referencedColumnName = "teacherId")
    private Teacher homeroomTeacherId;
}
