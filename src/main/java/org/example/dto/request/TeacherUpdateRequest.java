package org.example.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeacherUpdateRequest {
    private String name;
    private boolean isHomeroom;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
}
