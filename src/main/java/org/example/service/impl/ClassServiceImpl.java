package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.CreateClassRequest;
import org.example.dto.respone.ClassDTO;
import org.example.dto.respone.StudentDTO;
import org.example.entity.Classes;
import org.example.entity.Student;
import org.example.mapper.ClassMapper;
import org.example.mapper.StudentMapper;
import org.example.repository.ClassesRepository;
import org.example.repository.StudentRepository;
import org.example.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassesRepository classRepository;
    private final StudentRepository studentRepository;
    private final ClassMapper classMapper;

    @Override
    public List<ClassDTO> getAllClasses() {
        return classRepository.findAll()
                .stream()
                .map(classMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsOfClass(String classId) {
        List<Student> students = studentRepository.findByClasses_ClassId(classId);
        return students.stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Classes createClass(CreateClassRequest request){
        Classes classes = new Classes();
        classes.setClassName(request.getClassName());
        classes.setGrade(request.getGrade());
        return classRepository.save(classes);
    }

    @Override
    public void addStudentToClass(String classId, String studentId){
        Classes classes = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setClasses(classes);
        studentRepository.save(student);
    }
}
