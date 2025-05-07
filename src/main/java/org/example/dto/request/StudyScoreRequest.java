package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudyScoreRequest {
    private String studentId;
    private String teacherId;
    private String subject;
    private String semester;
    private Double score;
}
