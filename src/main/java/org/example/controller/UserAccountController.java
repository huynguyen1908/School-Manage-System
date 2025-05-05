package org.example.controller;

import org.example.dto.request.CreateAccountForParentRequest;
import org.example.dto.request.CreateAccountForStudentRequest;
import org.example.dto.request.CreateAccountForTeacherRequest;
import org.example.entity.UserAccount;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/parent")
    public ResponseEntity<UserAccount> createAccountForParent(@RequestBody CreateAccountForParentRequest request){
        UserAccount account = userAccountService.createAccountForParent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/student")
    public ResponseEntity<UserAccount> createAccountForStudent(@RequestBody CreateAccountForStudentRequest request){
        UserAccount account = userAccountService.createAccountForStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/teacher")
    public ResponseEntity<UserAccount> createAccountForTeacher(@RequestBody CreateAccountForTeacherRequest request){
        UserAccount account = userAccountService.createAccountForTeacher(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }
}
