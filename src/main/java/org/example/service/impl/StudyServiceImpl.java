package org.example.service.impl;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.StudyScoreDTO;
import org.example.entity.Assignment;
import org.example.entity.Student;
import org.example.entity.StudyScore;
import org.example.entity.Teacher;
import org.example.enums.Subject;
import org.example.mapper.AssignmentMapper;
import org.example.mapper.StudyScoreMapper;
import org.example.repository.AssignmentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.StudyScoreRepository;
import org.example.repository.TeacherRepository;
import org.example.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyScoreRepository scoreRepository;

    @Autowired
    private StudyScoreMapper scoreMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Override
    public List<StudyScoreDTO> getScoresByStudentId(String studentId) {
        return scoreRepository.findByStudent_StudentId(studentId).stream()
                .map(scoreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudyScoreDTO enterScore(StudyScoreRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        StudyScore score = new StudyScore();
        score.setStudent(student);
        score.setTeacher(teacher);
        score.setSubject(Subject.valueOf(request.getSubject()));
        score.setSemester(request.getSemester());
        score.setScore(request.getScore());

        return scoreMapper.toDTO(scoreRepository.save(score));
    }

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
