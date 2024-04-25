package com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterStaffRequest {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Invite code is required")
    private String inviteCode;

}
