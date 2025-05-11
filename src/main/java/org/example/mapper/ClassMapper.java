package org.example.mapper;

import org.example.dto.respone.ClassDTO;
import org.example.entity.Classes;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.example.entity.Assignment;


@Component
public class ClassMapper {
    public ClassDTO toDTO(Classes entity) {
        List<String> assignmentIds = entity.getAssignments() != null
                ? entity.getAssignments().stream()
                .map(Assignment::getAssignmentId)
                .collect(Collectors.toList())
                : Collections.emptyList();

        return new ClassDTO(
                entity.getClassId(),
                entity.getClassName(),
                entity.getGrade(),
                assignmentIds,
                entity.getHomeroomTeacherId() != null ? entity.getHomeroomTeacherId().getTeacherId() : null
        );
    }
}
