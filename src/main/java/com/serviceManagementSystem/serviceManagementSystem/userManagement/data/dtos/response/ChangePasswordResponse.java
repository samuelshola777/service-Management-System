package com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response;


import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordResponse {

    private String email;

    private SystemRole role;

    private String status;

}
