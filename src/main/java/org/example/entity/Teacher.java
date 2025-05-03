package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "teacher")
public class Teacher {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String teacherId;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserAccount userId;
    private String name;
    private String subject;
    private boolean isHomeroom;
    private LocalDate dateOfBirth;
    private String gender;

    @Column(unique = true)
    private String email;
}
