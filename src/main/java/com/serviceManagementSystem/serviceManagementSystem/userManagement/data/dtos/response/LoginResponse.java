package com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response;

import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.SystemRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String email;

    private SystemRole role;

}
