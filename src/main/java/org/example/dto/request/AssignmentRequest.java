package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {
    private String teacherId;
    private String subject;         // Enum dạng string
    private String title;
    private LocalDateTime dueDates;
    private String description;
}
