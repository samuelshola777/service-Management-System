package com.serviceManagementSystem.serviceManagementSystem.customer.controller;

import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.customer.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("registerCustomer")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(customerService.registerCustomer(registerRequest), HttpStatus.OK);
    }
        @PostMapping("loginCustomer")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest){
            return new ResponseEntity<>(customerService.login(loginRequest), HttpStatus.OK);
    }
        @PostMapping("logoutCustomer")
    public ResponseEntity<?> logoutCustomer(@RequestBody LoginRequest loginRequest){
            return new ResponseEntity<>(customerService.logout(loginRequest), HttpStatus.OK);
    }
        @PostMapping("updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody RegisterRequest registerRequest){
            return new ResponseEntity<>(customerService.updateCustomerProfile(registerRequest), HttpStatus.OK);
    }
        @PostMapping("changeCustomerPassword")
    public ResponseEntity<?> changeCustomerPassword(@RequestBody ChangePasswordRequest registerRequest){
            return new ResponseEntity<>(customerService.changeCustomerPassword(registerRequest), HttpStatus.OK);
    }

}
