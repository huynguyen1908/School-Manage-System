package org.example.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateTuitionRequest {
    private String parentId;
    private String departmentId;
    private BigDecimal amount;
    private LocalDate dueDate;
}
