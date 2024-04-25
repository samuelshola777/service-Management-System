package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;

import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterStaffRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

public interface BaseUserService {

    RegisterResponse registerCustomer(RegisterRequest registerRequest);

    LoginResponse loginCustomer(LoginRequest loginRequest);

    RegisterResponse registerStaff(RegisterStaffRequest staffRequest);

    LoginResponse loginStaff(LoginRequest loginRequest);

    RegisterResponse updateUserDetails(RegisterRequest registerRequest);

    OperationResponse changeUserPassword(ChangePasswordRequest registerRequest);

}
