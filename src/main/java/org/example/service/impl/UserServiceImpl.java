package org.example.service.impl;

import org.example.dto.respone.DepartmentDTO;
import org.example.dto.respone.ParentDTO;
import org.example.dto.respone.StudentDTO;
import org.example.dto.respone.TeacherDTO;
import org.example.entity.*;
import org.example.mapper.DepartmentMapper;
import org.example.mapper.ParentMapper;
import org.example.mapper.StudentMapper;
import org.example.mapper.TeacherMapper;
import org.example.repository.DepartmentRepository;
import org.example.repository.ParentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public StudentDTO getStudentById(String id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Lấy thông tin phụ huynh của học sinh
    @Override
    public ParentDTO getParentFromStudent(String studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Parent parent = student.getParent();
        return ParentMapper.toDTO(parent);
    }


    // Lấy danh sách học sinh mà phụ huynh đang giám hộ
    @Override
    public List<StudentDTO> getStudentsFromParent(String parentId) {
        return studentRepository.findByParentId(parentId)
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParentDTO getParentById(String id) {
        return parentRepository.findById(id)
                .map(ParentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
    }

    @Override
    public DepartmentDTO getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .map(DepartmentMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public TeacherDTO getTeacherById(String id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    public void assignParentToStudent(String studentId, String parentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        student.setParent(parent);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getStudentList() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDTO(
                        student.getStudentId(),
                        student.getName(),
                        student.getGender(),
                        student.getDateOfBirth(),
                        student.getClasses().getClassName(),
                        student.getParent().getName()
                ))
                .collect(Collectors.toList());
    }


}