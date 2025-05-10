package org.example.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UpdateTuitionRequest {
    private BigDecimal amount;
    private LocalDate dueDate;
    private String status;
}
