package org.example.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClassDTO {
    private String classId;
    private String className;
    private Integer grade;
    private List<String> assignmentIds;
    private String homeroomTeacherId;
}
