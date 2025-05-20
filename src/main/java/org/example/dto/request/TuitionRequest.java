package org.example.dto.request;

import lombok.Data;
import org.example.enums.TuitionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TuitionRequest {
    private String studentId;  // ID học sinh
    private String departmentId;  // ID khoa
    private LocalDate dueDate;  // Ngày hết hạn
    private BigDecimal amount;  // Số tiền học phí
    private TuitionStatus status;  // Trạng thái (ví dụ: PAID, UNPAID)
}
