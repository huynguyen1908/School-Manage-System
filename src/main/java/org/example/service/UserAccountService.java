package org.example.service;

import org.example.dto.request.CreateAccountForParentRequest;
import org.example.dto.request.CreateAccountForStudentRequest;
import org.example.dto.request.CreateAccountForTeacherRequest;
import org.example.entity.UserAccount;

public interface UserAccountService {
    UserAccount createAccountForParent(CreateAccountForParentRequest request);
    UserAccount createAccountForStudent(CreateAccountForStudentRequest request);
    UserAccount createAccountForTeacher(CreateAccountForTeacherRequest request);
}
