package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TeacherDTO {
    private String teacherId;
    private String name;
    private String subject;
    private boolean isHomeroom;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;
}
