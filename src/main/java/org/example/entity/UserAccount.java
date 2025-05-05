package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.Role;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_account")
public class UserAccount {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean isActive = true;
    private LocalDateTime createAt = LocalDateTime.now();

    private String createdBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
