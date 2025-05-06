package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDTO {
    private String studentId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String className;
    private String parentName;
}
