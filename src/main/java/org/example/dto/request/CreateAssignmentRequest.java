package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAssignmentRequest {
    private String classId;
    private String subject;
    private String title;
    private String description;
    private LocalDateTime dueDates;
    private String teacherId;
}
