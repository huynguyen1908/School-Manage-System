package org.example.service.impl;

import org.example.dto.request.CreateAccountForParentRequest;
import org.example.entity.Parent;
import org.example.entity.UserAccount;
import org.example.enums.Role;
import org.example.repository.ParentRepository;
import org.example.repository.UserAccountRepository;
import org.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    ParentRepository parentRepository;

    @Override
    public UserAccount createAccountForParent(CreateAccountForParentRequest request) {
        if (userAccountRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        UserAccount account = new UserAccount();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setRole(Role.PARENT);
        account = userAccountRepository.save(account);

        Parent parent = parentRepository.findById(request.getParentId())
                .orElseThrow(()-> new RuntimeException("Parent not found"));

        parent.setUser(account);
        parentRepository.save(parent);
        return account;
    }
}
