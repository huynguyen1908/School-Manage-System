package org.example.controller;

import org.example.dto.request.ParentUpdateRequest;
import org.example.dto.request.StudentUpdateRequest;
import org.example.dto.request.TeacherUpdateRequest;
import org.example.dto.respone.*;
import org.example.repository.StudentRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getStudentById(id));
    }

    @GetMapping("/students/{id}/parents")
    public ResponseEntity<ParentDTO> getParentFromStudent(@PathVariable String id) {
        return ResponseEntity.ok(userService.getParentFromStudent(id));
    }

    @GetMapping("/parents/{id}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsFromParent(@PathVariable String id) {
        return ResponseEntity.ok(userService.getStudentsFromParent(id));
    }

    @GetMapping("/parents/{id}")
    public ResponseEntity<ParentDTO> getParentById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getParentById(id));
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getDepartmentById(id));
    }
    @PutMapping("/students/{studentId}/assign-parent/{parentId}")
    public ResponseEntity<String> assignParentToStudent(@PathVariable String studentId, @PathVariable String parentId){
        userService.assignParentToStudent(studentId,parentId);
        return ResponseEntity.ok("Parent assigned to student successfully.");
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudentList(){
        return ResponseEntity.ok(userService.getStudentList());
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getTeacherById(id));
    }
    @GetMapping("/teachers")
    public List<TeacherDTO> getTeacherList() {
        return userService.getTeacherList();
    }
//    @GetMapping("/teachers/{id}/assignments")
//    public List<AssignmentDTO> getTeacherAssignments(@PathVariable String id) {
//        return userService.getAssignmentsByTeacherId(id);
//    }

    @GetMapping("/by-student/{userId}")
    public ResponseEntity<StudentDTO> getStudentByUserId(@PathVariable String userId) {
        StudentDTO studentDTO = userService.getStudentByUserId(userId);
        return ResponseEntity.ok(studentDTO);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<TeacherDTO> editTeacherDetail(@PathVariable String id, @RequestBody TeacherUpdateRequest request) {
        TeacherDTO updated = userService.editTeacherDetail(id, request);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDTO> editStudentDetail(@PathVariable String id, @RequestBody StudentUpdateRequest request) {
        StudentDTO updated = userService.editStudentDetail(id, request);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/parent/{id}")
    public ResponseEntity<ParentDTO> editParentDetail(@PathVariable String id, @RequestBody ParentUpdateRequest request) {
        ParentDTO updated = userService.editParentDetail(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/by-teacher/{userId}")
    public ResponseEntity<TeacherDTO> getTeacherByUserId(@PathVariable String userId) {
        TeacherDTO teacherDTO = userService.getTeacherByUserId(userId);
        return ResponseEntity.ok(teacherDTO);
    }

}
