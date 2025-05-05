package org.example.service.impl;

import org.example.dto.request.CreateAccountForParentRequest;
import org.example.dto.request.CreateAccountForStudentRequest;
import org.example.dto.request.CreateAccountForTeacherRequest;
import org.example.entity.Parent;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.entity.UserAccount;
import org.example.enums.Role;
import org.example.repository.ParentRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.example.repository.UserAccountRepository;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount createAccountForParent(CreateAccountForParentRequest request) {
        if (userAccountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }


        UserAccount account = new UserAccount();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(Role.PARENT);
        account = userAccountRepository.save(account);

        if (request.getParentId() == null || request.getParentId().isBlank() ) {
            Parent parent = new Parent();
            parent.setUser(account);
            parentRepository.save(parent);
        }

        return account;
    }

    @Override
    public UserAccount createAccountForStudent(CreateAccountForStudentRequest request) {
        if (userAccountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        UserAccount account = new UserAccount();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(Role.STUDENT);
        account = userAccountRepository.save(account);

        if (request.getStudentId() == null || request.getStudentId().isBlank() ) {
            Student student = new Student();
            student.setUser(account);
            studentRepository.save(student);
        }

        return account;
    }

    @Override
    public UserAccount createAccountForTeacher(CreateAccountForTeacherRequest request) {
        if (userAccountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        UserAccount account = new UserAccount();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(Role.TEACHER);
        account = userAccountRepository.save(account);

        if (request.getStudentId() == null || request.getStudentId().isBlank() ) {
            Teacher teacher = new Teacher();
            teacher.setUser(account);
            teacherRepository.save(teacher);
        }

        return account;
    }
}
