package org.example.mapper;

import org.example.dto.respone.TeacherDTO;
import org.example.entity.Teacher;

public class TeacherMapper {
    public static TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
                teacher.getTeacherId(),
                teacher.getName(),
                teacher.getSubject(),
                teacher.isHomeroom(),
                teacher.getDateOfBirth(),
                teacher.getGender(),
                teacher.getEmail()
        );
    }
}
