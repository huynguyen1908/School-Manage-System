package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String id;
    private String username;
    private String role;
    private String jwt;
}

