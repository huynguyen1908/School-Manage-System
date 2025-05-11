package org.example.service.impl;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.request.CreateAssignmentRequest;
import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.dto.respone.StudyScoreDTO;
import org.example.entity.*;
import org.example.enums.Subject;
import org.example.mapper.AssignmentMapper;
import org.example.mapper.StudyScoreMapper;
import org.example.repository.*;
import org.example.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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

    @Autowired
    private ClassesRepository classesRepository;

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

    @Override
    public StudyScoreDTO updateScore(String scoreId, StudyScoreRequest request) {
        // 1. Lấy entity ra
        StudyScore entity = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new RuntimeException("Score not found"));

        // 2. Chỉ cập nhật trường score
        entity.setScore(request.getScore());

        // 3. Lưu và trả về DTO
        StudyScore saved = scoreRepository.save(entity);
        return scoreMapper.toDTO(saved);
    }
    @Override
    public List<AssignmentDTO> getAssignmentsOfTeacher(String teacherId) {
        List<Assignment> assignments = assignmentRepository.findByTeacherId(teacherId);
        return assignments.stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<AssignmentDTO> getAssignmentsOfStudent(String studentId) {
        List<Assignment> assignments = studentRepository.findAssignmentsByStudentId(studentId);
        return assignments.stream()
                .map(a -> new AssignmentDTO(
                        a.getAssignmentId(),
                        a.getSubject().toString(),
                        a.getTitle(),
                        a.getDueDates(),
                        a.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentDTO createAssignment(CreateAssignmentRequest request) {
        Classes classes = classesRepository.findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found with ID: " + request.getClassId()));

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + request.getTeacherId()));

        Assignment assignment = new Assignment();
        assignment.setClasses(classes);
        assignment.setTeacher(teacher);
        assignment.setSubject(Subject.valueOf(request.getSubject()));
        assignment.setTitle(request.getTitle());
        assignment.setDescription(request.getDescription());
        assignment.setDueDates(request.getDueDates());

        assignmentRepository.save(assignment);
        return new AssignmentDTO(
                assignment.getAssignmentId(),
                assignment.getSubject().toString(),
                assignment.getTitle(),
                assignment.getDueDates(),
                assignment.getDescription()
        );
    }

    @Override
    public AssignmentDTO getAssignmentById(String assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found with ID: " + assignmentId));

        return new AssignmentDTO(
                assignment.getAssignmentId(),
                assignment.getSubject().toString(),
                assignment.getTitle(),
                assignment.getDueDates(),
                assignment.getDescription()
        );
    }

}