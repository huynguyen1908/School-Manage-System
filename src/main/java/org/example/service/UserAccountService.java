package org.example.service;

import org.example.dto.request.CreateAccountForParentRequest;
import org.example.entity.UserAccount;

public interface UserAccountService {
    UserAccount createAccountForParent(CreateAccountForParentRequest request);
}
