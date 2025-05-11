package org.example.service;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.StudyScoreDTO;

import java.util.List;

public interface StudyService {
    List<StudyScoreDTO> getScoresByStudentId(String studentId);
    StudyScoreDTO enterScore(StudyScoreRequest request);

    List<AssignmentDTO> getAllAssignments();
    AssignmentDTO createAssignment(AssignmentRequest request);
    StudyScoreDTO updateScore(String scoreId, StudyScoreRequest request);
    List<AssignmentDTO> getAssignmentsOfTeacher(String teacherId);

}
