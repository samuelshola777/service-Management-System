package com.serviceManagementSystem.serviceManagementSystem.appUser.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    private String email;
    private String password;
    private String fullName;
    private SystemRole role;
    private LocalDateTime registrationDate;
}
