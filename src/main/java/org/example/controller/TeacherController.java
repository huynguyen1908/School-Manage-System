package org.example.controller;

import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.TeacherDTO;
import org.example.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDTO> getTeacherList() {
        return teacherService.getTeacherList();
    }
    @GetMapping("/{id}/assignments")
    public List<AssignmentDTO> getTeacherAssignments(@PathVariable String id) {
        return teacherService.getAssignmentsByTeacherId(id);
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }
}
