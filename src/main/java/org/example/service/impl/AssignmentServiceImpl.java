package org.example.service.impl;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.entity.Assignment;
import org.example.entity.Teacher;
import org.example.enums.Subject;
import org.example.mapper.AssignmentMapper;
import org.example.repository.AssignmentRepository;
import org.example.repository.TeacherRepository;
import org.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return assignmentRepository.findAll()
                .stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentRequest request) {
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Assignment assignment = new Assignment();
        assignment.setTeacher(teacher);
        assignment.setSubject(Subject.valueOf(request.getSubject()));
        assignment.setTitle(request.getTitle());
        assignment.setDueDates(request.getDueDates());
        assignment.setDescription(request.getDescription());

        return assignmentMapper.toDTO(assignmentRepository.save(assignment));
    }
}
