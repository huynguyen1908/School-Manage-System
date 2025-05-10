package org.example.service;

import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getTeacherList();
    TeacherDTO getTeacherById(String id);
    List<AssignmentDTO> getAssignmentsByTeacherId(String teacherId);
}
