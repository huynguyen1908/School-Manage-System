package org.example.service;

import org.example.dto.respone.*;

import java.util.List;

public interface UserService {
    StudentDTO getStudentById(String id);

    ParentDTO getParentFromStudent(String studentId);

    List<StudentDTO> getStudentsFromParent(String parentId);

    ParentDTO getParentById(String id);

    DepartmentDTO getDepartmentById(String id);

    TeacherDTO getTeacherById(String id);
    void assignParentToStudent(String studentId, String parentId);

    List<StudentDTO> getStudentList();

    List<TeacherDTO> getTeacherList();
    List<AssignmentDTO> getAssignmentsByTeacherId(String teacherId);

}
