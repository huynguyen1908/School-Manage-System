package org.example.service.impl;

import org.example.dto.request.CreateAccountForDepartmentRequest;
import org.example.dto.request.CreateAccountForParentRequest;
import org.example.dto.request.CreateAccountForStudentRequest;
import org.example.dto.request.CreateAccountForTeacherRequest;
import org.example.dto.respone.UserAccountDTO;
import org.example.entity.*;
import org.example.enums.Role;
import org.example.mapper.UserAccountMapper;
import org.example.repository.*;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    DepartmentRepository departmentRepository;

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

    @Override
    public UserAccount createAccountForDepartment(CreateAccountForDepartmentRequest request) {
        if (userAccountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        UserAccount account = new UserAccount();
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setRole(request.getRole());
        account = userAccountRepository.save(account);

        if (request.getDepartmentId() == null || request.getDepartmentId().isBlank() ) {
            Department department = new Department();
            department.setDepartmentName(request.getRole().toString().toLowerCase());
            department.setUser(account);
            departmentRepository.save(department);
        }

        return account;
    }

    @Override
    public void deleteAccount(String id){
        UserAccount account = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        account.setActive(false);
        userAccountRepository.save(account);
    }

    @Override
    public List<UserAccount> getAllAccount(){
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccountDTO getAccountById(String id){
        return userAccountRepository.findById(id)
                .map(UserAccountMapper::toDTO).orElseThrow(()-> new RuntimeException("Không tìm thấy account"));
    }

    @Override
    public String getUserFullName(UserAccount user) {
        switch (user.getRole().name()) {
            case "STUDENT":
                return studentRepository.findByUser(user)
                        .map(Student::getName)
                        .orElse("Unknown Student");
            case "TEACHER":
                return teacherRepository.findByUser(user)
                        .map(Teacher::getName)
                        .orElse("Unknown Teacher");
            case "PARENT":
                return parentRepository.findByUser(user)
                        .map(Parent::getName)
                        .orElse("Unknown Parent");
            case "DEPARTMENT":
                return departmentRepository.findByUser(user)
                        .map(Department::getDepartmentName)
                        .orElse("Unknown Department");
            default:
                return "Unknown";
        }
    }
}
