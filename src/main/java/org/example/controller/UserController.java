package org.example.controller;

import org.example.dto.respone.DepartmentDTO;
import org.example.dto.respone.ParentDTO;
import org.example.dto.respone.StudentDTO;
import org.example.dto.respone.TeacherDTO;
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

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getTeacherById(id));
    }

    @PutMapping("/students/{studentId}/assign-parent/{parentId}")
    public ResponseEntity<String> assignParentToStudent(@PathVariable String studentId, @PathVariable String parentId){
        userService.assignParentToStudent(studentId,parentId);
        return ResponseEntity.ok("Parent assigned to student successfully.");
    }

}
