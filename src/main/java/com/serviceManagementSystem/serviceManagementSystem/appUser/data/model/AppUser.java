package com.serviceManagementSystem.serviceManagementSystem.appUser.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser {

    private String email;
    private String password;
    private String fullName;
    private SystemRole role;
}
