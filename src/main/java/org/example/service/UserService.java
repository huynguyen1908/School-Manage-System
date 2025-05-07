package org.example.service;

import org.example.dto.respone.DepartmentDTO;
import org.example.dto.respone.ParentDTO;
import org.example.dto.respone.StudentDTO;
import org.example.dto.respone.TeacherDTO;

import java.util.List;

public interface UserService {
    StudentDTO getStudentById(String id);

    ParentDTO getParentFromStudent(String studentId);

    List<StudentDTO> getStudentsFromParent(String parentId);

    ParentDTO getParentById(String id);

    DepartmentDTO getDepartmentById(String id);

    TeacherDTO getTeacherById(String id);
    void assignParentToStudent(String studentId, String parentId);
}
