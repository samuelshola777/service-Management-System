package com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request;

import lombok.Data;

@Data

public class ChangePasswordRequest {
    private String customerEmail;
    private String password;
    private String newPassword;
}
