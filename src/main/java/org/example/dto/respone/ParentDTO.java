package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ParentDTO {
    private String parentId;
    private String name;
    private Integer age;
    private String occupation;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
