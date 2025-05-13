package org.example.service.impl;

import org.example.dto.request.ParentUpdateRequest;
import org.example.dto.request.StudentUpdateRequest;
import org.example.dto.request.TeacherUpdateRequest;
import org.example.dto.respone.*;
import org.example.entity.*;
import org.example.mapper.*;
import org.example.repository.*;
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

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;


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
                .map(TeacherMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }


//    @Override
//    public List<AssignmentDTO> getAssignmentsByTeacherId(String teacherId) {
//        return assignmentRepository.findByTeacher_TeacherId(teacherId).stream()
//                .map(assignmentMapper::toDTO)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public Object getStudentByUserId(UserAccount user) {
//        switch (user.getRole().name()) {
//            case "STUDENT":
//                return studentRepository.findByUser(user)
//                        .map(StudentMapper::toDTO)
//                        .orElseThrow(()-> new RuntimeException("Student not found"));
//            case "TEACHER":
//                return teacherRepository.findByUser(user)
//                        .map(TeacherMapper::toDTO)
//                        .orElseThrow(()-> new RuntimeException("Teacher not found"));
//            case "PARENT":
//                return parentRepository.findByUser(user)
//                        .map(ParentMapper::toDTO)
//                        .orElseThrow(()-> new RuntimeException("Parent not found"));
//            case "MANAGE":
//                return departmentRepository.findByUser(user)
//                        .map(DepartmentMapper::toDTO)
//                        .orElseThrow(()-> new RuntimeException("Department not found"));
//            default:
//                return "Unknown";
//        }
//    }

    @Override
    public StudentDTO getStudentByUserId(String userId) {
       return studentRepository.findByUser_UserId(userId)
               .map(StudentMapper::toDTO)
               .orElseThrow(() -> new RuntimeException("Student not found for userId: " + userId));

    }

    @Override
    public TeacherDTO editTeacherDetail(String id, TeacherUpdateRequest request){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setName(request.getName());
        teacher.setHomeroom(request.isHomeroom());
        teacher.setDateOfBirth(request.getDateOfBirth());
        teacher.setGender(request.getGender());
        teacher.setEmail(request.getEmail());
        Teacher updatedTeacher = teacherRepository.save(teacher);

        return TeacherMapper.toDTO(updatedTeacher);
    }

    @Override
    public StudentDTO editStudentDetail(String id, StudentUpdateRequest request){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(request.getName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGender(request.getGender());

        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.toDTO(updatedStudent);
    }

    @Override
    public ParentDTO editParentDetail(String id, ParentUpdateRequest request) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        parent.setName(request.getName());
        parent.setAge(request.getAge());
        parent.setOccupation(request.getOccupation());
        parent.setPhoneNumber(request.getPhoneNumber());
        parent.setDateOfBirth(request.getDateOfBirth());

        Parent updatedParent = parentRepository.save(parent);
        return ParentMapper.toDTO(updatedParent);
    }

    @Override
    public TeacherDTO getTeacherByUserId(String userId) {
        return teacherRepository.findByUser_UserId(userId)
                .map(TeacherMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Teacher not found for userId: "));

    }
}