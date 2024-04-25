package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;

import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.*;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

public interface BaseUserService {

    RegisterResponse registerCustomer(RegisterRequest registerRequest);

    LoginResponse loginCustomer(LoginRequest loginRequest);

    RegisterResponse registerStaff(RegisterStaffRequest staffRequest);

    LoginResponse loginStaff(LoginRequest loginRequest);

    RegisterResponse updateUserDetails(RegisterRequest registerRequest);

    OperationResponse changeUserPassword(ChangePasswordRequest registerRequest);

    OperationResponse deleteUserAccount(DeleteRequest deleteRequest);

    BaseUser getUserByEmail(String email);

    BaseUser getCustomerUserByEmail(String email);

    BaseUser getStaffUserByEmail(String email);

}
