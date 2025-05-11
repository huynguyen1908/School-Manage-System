package org.example.controller;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.StudyScoreDTO;
import org.example.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyController {

    @Autowired
    private StudyService studyScoreService;


    @GetMapping("/students/{id}/scores")
    public List<StudyScoreDTO> getStudentScore(@PathVariable String id) {
        return studyScoreService.getScoresByStudentId(id);
    }

    @PostMapping("/scores")
    public StudyScoreDTO enterScore(@RequestBody StudyScoreRequest request) {
        return studyScoreService.enterScore(request);
    }
    @PostMapping("/assignments")
    public AssignmentDTO sendAssignment(@RequestBody AssignmentRequest request) {
        return studyService.createAssignment(request);
    }
    @GetMapping
    public List<AssignmentDTO> getAssignments() {
        return studyScoreService.getAllAssignments();
    }
    @Autowired
    private StudyService studyService;
    @PutMapping("/scores/{scoreId}")
    public ResponseEntity<StudyScoreDTO> updateScore(
            @PathVariable("scoreId") String scoreId,
            @RequestBody StudyScoreRequest request) {
        StudyScoreDTO updated = studyService.updateScore(scoreId, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/assignments/teacher/{teacherId}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsOfTeacher(@PathVariable("teacherId") String teacherId) {
        return ResponseEntity.ok(studyService.getAssignmentsOfTeacher(teacherId));
    }


}
