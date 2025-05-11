package org.example.dto.respone;

import lombok.Data;
import org.example.enums.TuitionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data // Lombok sẽ tự sinh getter, setter, constructor, v.v.
public class TuitionDTO {
    private String tuitionId;
    private String studentId;  // Chỉ ánh xạ ID của Student
    private String departmentId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDateTime paidAt;
    private TuitionStatus status;
}
