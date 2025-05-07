package org.example.service;

import org.example.dto.respone.ClassDTO;
import org.example.dto.respone.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassService {
    List<ClassDTO> getAllClasses();
    List<StudentDTO> getStudentsOfClass(String classId);
}
