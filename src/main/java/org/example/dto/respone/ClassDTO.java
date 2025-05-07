package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassDTO {
    private String classId;
    private String className;
    private Integer grade;
    private String assignmentId;
    private String homeroomTeacherId;
}
