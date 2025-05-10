package org.example.controller;

import lombok.Getter;
import org.example.dto.request.CreateAccountForDepartmentRequest;
import org.example.dto.request.CreateAccountForParentRequest;
import org.example.dto.request.CreateAccountForStudentRequest;
import org.example.dto.request.CreateAccountForTeacherRequest;
import org.example.dto.respone.UserAccountDTO;
import org.example.entity.UserAccount;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/department")
    public ResponseEntity<UserAccount> createAccountForDepartment(@RequestBody CreateAccountForDepartmentRequest request){
        UserAccount account = userAccountService.createAccountForDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable String id){
        userAccountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<UserAccount>> getAllAccount(){
        return ResponseEntity.ok().body(userAccountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDTO> getAccountById(@PathVariable String id){
        return ResponseEntity.ok().body(userAccountService.getAccountById(id));
    }
}
