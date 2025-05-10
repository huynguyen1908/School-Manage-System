
package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyScoreDTO {
    private String scoreId;
    private String subject;
    private Double score;
    private String semester;
    private String teacherID;
}
