package org.example.mapper;

import org.example.dto.respone.TeacherDTO;
import org.example.dto.respone.UserAccountDTO;
import org.example.entity.Teacher;
import org.example.entity.UserAccount;

public class UserAccountMapper {
    public static UserAccountDTO toDTO(UserAccount userAccount) {
        return new UserAccountDTO(
                userAccount.getUserId(),
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.isActive(),
                userAccount.getCreateAt(),
                userAccount.getCreatedBy(),
                userAccount.getRole().toString()
        );
    }
}
