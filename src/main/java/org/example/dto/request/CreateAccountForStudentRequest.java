package org.example.dto.request;

import lombok.Data;

@Data
public class CreateAccountForStudentRequest {
    String username;
    String password;
    String studentId;
}
