package org.example.dto.request;

import lombok.Data;

@Data
public class CreateAccountForTeacherRequest {
    String username;
    String password;
    String studentId;
}
