package org.example.service;

import org.example.dto.request.LoginRequest;
import org.example.dto.respone.LoginResponse;


public interface AuthService {
    LoginResponse login(LoginRequest request);
}
