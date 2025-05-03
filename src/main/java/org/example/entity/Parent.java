package org.example.entity;

import jakarta.persistence.*;
import jakarta.websocket.OnError;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "parent")
@Data
public class Parent {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String parentId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserAccount userId;

    private String name;
    private Integer age;
    private String occupation;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
