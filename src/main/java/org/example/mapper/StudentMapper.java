package org.example.mapper;

import org.example.dto.respone.StudentDTO;
import org.example.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getName(),
                student.getGender(),
                student.getDateOfBirth(),
                student.getClasses() != null ? student.getClasses().getClassName() : null,
                student.getParent() != null ? student.getParent().getName() : null
        );
    }
}
