package org.example.dto.request;

import lombok.Data;

@Data
public class CreateAccountForParentRequest {
    String username;
    String password;
    String parentId;
}
