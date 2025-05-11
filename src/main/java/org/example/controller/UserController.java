package org.example.controller;

import org.example.dto.respone.*;
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
    @GetMapping("/teachers/{id}/assignments")
    public List<AssignmentDTO> getTeacherAssignments(@PathVariable String id) {
        return userService.getAssignmentsByTeacherId(id);
    }

}
