package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String studentId;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "classId")
    private Classes classes;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "parentId")
    private Parent parent;

    private String name;

    private LocalDate dateOfBirth;

    private String gender;
}
