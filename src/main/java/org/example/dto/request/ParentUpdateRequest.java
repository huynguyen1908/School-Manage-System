package org.example.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ParentUpdateRequest {
    private String name;
    private Integer age;
    private String occupation;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}