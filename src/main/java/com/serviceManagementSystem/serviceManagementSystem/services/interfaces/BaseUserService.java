package com.serviceManagementSystem.serviceManagementSystem.services.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.DeleteRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.*;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.data.models.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;

public interface BaseUserService {

    RegisterResponse registerCustomer(RegisterRequest registerRequest);

    LoginResponse loginCustomer(LoginRequest loginRequest);

    OperationResponse inviteStaff(String email);

    RegisterResponse registerStaff(RegisterRequest staffRequest);

    LoginResponse loginStaff(LoginRequest loginRequest);

    RegisterResponse updateUserDetails(RegisterRequest registerRequest);

    OperationResponse changeUserPassword(ChangePasswordRequest registerRequest);

    OperationResponse deleteUserAccount(DeleteRequest deleteRequest);

    BaseUser getUserByEmail(String email);

    BaseUser getCustomerUserByEmail(String email);

    BaseUser getStaffUserByEmail(String email);

}
