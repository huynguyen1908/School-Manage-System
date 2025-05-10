package org.example.dto.respone;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.Role;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAccountDTO {
    private String userId;
    private String username;
    private String password;
    private boolean isActive = true;
    private LocalDateTime createAt = LocalDateTime.now();
    private String createdBy;
    private String role;
}
