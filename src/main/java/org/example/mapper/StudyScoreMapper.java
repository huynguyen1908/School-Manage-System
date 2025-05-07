package org.example.mapper;

import org.example.dto.respone.StudyScoreDTO;
import org.example.entity.StudyScore;
import org.springframework.stereotype.Component;

@Component
public class StudyScoreMapper {
    public StudyScoreDTO toDTO(StudyScore score) {
        return new StudyScoreDTO(
                score.getScoreId(),
                score.getSubject().name(),
                score.getScore(),
                score.getSemester(),
                score.getTeacher() != null ? score.getTeacher().getName() : null
        );

    }
}