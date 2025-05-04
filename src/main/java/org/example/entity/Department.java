package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.Role;

@Entity
@Data
@Table(name = "department")
public class Department {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String departmentId;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserAccount user;

    private String departmentName;
    private String phoneNumber;
}
