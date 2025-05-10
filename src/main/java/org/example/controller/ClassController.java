package org.example.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.CreateClassRequest;
import org.example.dto.respone.ClassDTO;
import org.example.dto.respone.StudentDTO;
import org.example.entity.Classes;
import org.example.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @GetMapping
    public ResponseEntity<List<ClassDTO>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsOfClass(@PathVariable String id) {
        return ResponseEntity.ok(classService.getStudentsOfClass(id));
    }

    @PostMapping
    public ResponseEntity<Classes> createClass(@RequestBody CreateClassRequest request) {
        Classes newClass = classService.createClass(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClass);
    }

    @PostMapping("/{classId}/students/{studentId}")
    public ResponseEntity<String> addStudentToClass(
            @PathVariable String classId,
            @PathVariable String studentId) {
        classService.addStudentToClass(classId, studentId);
        return ResponseEntity.ok("Student added to class successfully");
    }
}
