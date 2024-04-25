package com.serviceManagementSystem.serviceManagementSystem.customer.service.interfaces;

import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.response.RegisterResponse;

public interface CustomerService {

    RegisterResponse registerCustomer(RegisterRequest registerRequest);
    RegisterResponse login(LoginRequest loginRequest);
    RegisterResponse logout(LoginRequest loginRequest);
    RegisterResponse updateCustomerProfile(RegisterRequest registerRequest);
    RegisterResponse changeCustomerPassword(ChangePasswordRequest registerRequest);

}
