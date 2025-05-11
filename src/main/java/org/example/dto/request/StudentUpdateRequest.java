package org.example.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentUpdateRequest {
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
}
