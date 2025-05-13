package org.example.service;

import org.example.dto.request.ParentUpdateRequest;
import org.example.dto.request.StudentUpdateRequest;
import org.example.dto.request.TeacherUpdateRequest;
import org.example.dto.respone.*;
import org.example.entity.UserAccount;

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

//    List<AssignmentDTO> getAssignmentsByTeacherId(String teacherId);

    //    Object getStudentByUserId(UserAccount user);
    StudentDTO getStudentByUserId(String userId);
    TeacherDTO editTeacherDetail(String id, TeacherUpdateRequest request);
    StudentDTO editStudentDetail(String id, StudentUpdateRequest request);
    ParentDTO editParentDetail(String id, ParentUpdateRequest request);

    TeacherDTO getTeacherByUserId(String userId);
}
