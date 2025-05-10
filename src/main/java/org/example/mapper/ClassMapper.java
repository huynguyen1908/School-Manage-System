package org.example.mapper;

import org.example.dto.respone.ClassDTO;
import org.example.entity.Classes;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {
    public ClassDTO toDTO(Classes entity) {
        return new ClassDTO(
                entity.getClassId(),
                entity.getClassName(),
                entity.getGrade(),
                entity.getAssignment() != null ? entity.getAssignment().getAssignmentId() : null,
                entity.getHomeroomTeacher() != null ? entity.getHomeroomTeacher().getTeacherId() : null
        );
    }
}
