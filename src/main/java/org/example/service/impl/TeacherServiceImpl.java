package org.example.service.impl;

import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.TeacherDTO;
import org.example.entity.Teacher;
import org.example.mapper.AssignmentMapper;
import org.example.mapper.TeacherMapper;
import org.example.repository.AssignmentRepository;
import org.example.repository.TeacherRepository;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getTeacherList() {
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::toDTO) // ✔ GỌI THEO STATIC
                .collect(Collectors.toList());
    }


    @Override
    public TeacherDTO getTeacherById(String id) {
        return teacherRepository.findById(id)
                .map(TeacherMapper::toDTO) // ✔ GỌI THEO STATIC
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Override
    public List<AssignmentDTO> getAssignmentsByTeacherId(String teacherId) {
        return assignmentRepository.findByTeacher_TeacherId(teacherId).stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }
}