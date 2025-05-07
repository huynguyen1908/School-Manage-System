package org.example.service;

import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.StudyScoreDTO;

import java.util.List;

public interface StudyScoreService {
    List<StudyScoreDTO> getScoresByStudentId(String studentId);
    StudyScoreDTO enterScore(StudyScoreRequest request);
}
