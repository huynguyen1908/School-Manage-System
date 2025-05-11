package org.example.controller;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.request.CreateAssignmentRequest;
import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.StudyScoreDTO;
import org.example.entity.Assignment;
import org.example.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study")
public class StudyController {

    @Autowired
    private StudyService studyService;


    @GetMapping("/students/{id}/scores")
    public List<StudyScoreDTO> getStudentScore(@PathVariable String id) {
        return studyService.getScoresByStudentId(id);
    }

    @PostMapping("/scores")
    public StudyScoreDTO enterScore(@RequestBody StudyScoreRequest request) {
        return studyService.enterScore(request);
    }
    @PostMapping("/assignments")
    public AssignmentDTO sendAssignment(@RequestBody AssignmentRequest request) {
        return studyService.createAssignment(request);
    }
    @GetMapping
    public List<AssignmentDTO> getAssignments() {
        return studyService.getAllAssignments();
    }

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

    @GetMapping("/assignments/student/{studentId}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsOfStudent(@PathVariable String studentId) {
        List<AssignmentDTO> assignments = studyService.getAssignmentsOfStudent(studentId);
        return ResponseEntity.ok(assignments);
    }

    @PostMapping("/assignment/create")
    public ResponseEntity<AssignmentDTO> createAssignment(@RequestBody CreateAssignmentRequest request) {
        AssignmentDTO createdAssignment = studyService.createAssignment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<AssignmentDTO> getAssignmentById(@PathVariable String assignmentId) {
        AssignmentDTO assignment = studyService.getAssignmentById(assignmentId);
        return ResponseEntity.ok(assignment);
    }

}
