package org.example.service.impl;

import org.example.dto.request.LoginRequest;
import org.example.dto.respone.LoginResponse;
import org.example.entity.UserAccount;
import org.example.repository.UserAccountRepository;
import org.example.service.AuthService;
import org.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;
    @Override
    public LoginResponse login(LoginRequest request) {
        UserAccount account = userAccountRepository.findByUsername(request.getUsername())
                .orElseThrow(()->new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String jwtToken = jwtUtil.generateToken(account.getUsername());

        return new LoginResponse(
                account.getUserId(),
                account.getUsername(),
                account.getRole().toString(),
                jwtToken
        );
    }
}
