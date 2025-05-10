package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "classes")
@Data
public class Classes {
    @Id
    @Column(name = "class_id")
    private String classId;
    
    @Column(name = "class_name")
    private String className;
    
    @Column(name = "grade")
    private Integer grade;
    
    @OneToOne
    @JoinColumn(name = "homeroom_teacher_id")
    private Teacher homeroomTeacher;
    
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;
    
    @OneToMany(mappedBy = "classes")
    private List<Student> students;
}
