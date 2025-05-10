package org.example.service;

import org.example.dto.request.CreateClassRequest;
import org.example.dto.respone.ClassDTO;
import org.example.dto.respone.StudentDTO;
import org.example.entity.Classes;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassService {
    List<ClassDTO> getAllClasses();
    List<StudentDTO> getStudentsOfClass(String classId);
    Classes createClass(CreateClassRequest request);
    void addStudentToClass(String classId, String studentId);
}
