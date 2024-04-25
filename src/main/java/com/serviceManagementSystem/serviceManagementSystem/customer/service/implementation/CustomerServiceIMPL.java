package com.serviceManagementSystem.serviceManagementSystem.customer.service.implementation;

import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import com.serviceManagementSystem.serviceManagementSystem.appUser.service.interfaces.AppUserService;
import com.serviceManagementSystem.serviceManagementSystem.customer.data.model.Customer;
import com.serviceManagementSystem.serviceManagementSystem.customer.data.repository.CustomerRepository;
import com.serviceManagementSystem.serviceManagementSystem.customer.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final AppUserService appUserService;
    private final CustomerRepository customerRepository;


    @Override
    public RegisterResponse registerCustomer(RegisterRequest registerRequest) {
        registerRequest.setRole(SystemRole.CUSTOMER);
        Customer customer = new Customer();
        customer.setRegistrationDate(LocalDateTime.now());
        customer.setAppUser( appUserService.registerAppUser(registerRequest));
        return new RegisterResponse("registration completed successfully");
    }

    @Override
    public RegisterResponse login(LoginRequest loginRequest) {
        return appUserService.loginAppUser(loginRequest);
    }

    @Override
    public RegisterResponse logout(LoginRequest loginRequest) {
        return appUserService.logOutAppUser(loginRequest);
    }

    @Override
    public RegisterResponse updateCustomerProfile(RegisterRequest registerRequest) {
        return appUserService.updateAppUser(registerRequest);
    }

    @Override
    public RegisterResponse changeCustomerPassword(ChangePasswordRequest registerRequest) {
        return appUserService.changePassword(registerRequest);
    }


}
