package org.example.dto.request;

import lombok.Data;
import org.example.enums.Role;

@Data
public class CreateAccountForDepartmentRequest {
    String username;
    String password;
    String departmentId;
    Role role;
}
