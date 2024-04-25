package com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private SystemRole role;
}
