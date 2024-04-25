package com.serviceManagementSystem.serviceManagementSystem.appUser.service.interfaces;


import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import com.serviceManagementSystem.serviceManagementSystem.appUser.data.repository.AppUserRepository;

public interface AppUserService {
    AppUser registerAppUser(RegisterRequest request);
    RegisterResponse loginAppUser(LoginRequest request);
    RegisterResponse logOutAppUser(LoginRequest request);
}
