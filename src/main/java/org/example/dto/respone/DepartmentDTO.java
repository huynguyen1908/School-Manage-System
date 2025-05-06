package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private String departmentId;
    private String departmentName;
    private String phoneNumber;
}
