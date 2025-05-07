package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDTO {
    private String assignmentId;
    private String subject;
    private String title;
    private LocalDateTime dueDates;
    private String description;
}
