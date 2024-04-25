package com.serviceManagementSystem.serviceManagementSystem.userManagement.controller;


import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterStaffRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.service.BaseUserService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final BaseUserService userService;

    @PostMapping("/registerCustomer")
    public ResponseEntity<RegisterResponse> registerCustomer(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.registerCustomer(registerRequest), HttpStatus.OK);
    }

    @PostMapping("loginCustomer")
    public ResponseEntity<LoginResponse> loginCustomer(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.loginCustomer(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/registerStaff")
    public ResponseEntity<RegisterResponse> registerStaff(@RequestBody RegisterStaffRequest staffRequest) {
        return new ResponseEntity<>(userService.registerStaff(staffRequest), HttpStatus.OK);
    }

    @PostMapping("/loginStaff")
    public ResponseEntity<LoginResponse> loginStaff(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.loginStaff(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/updateUserDetails")
    public ResponseEntity<RegisterResponse> updateUserDetails(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.updateUserDetails(registerRequest), HttpStatus.OK);
    }

    @PostMapping("/changeCustomerPassword")
    public ResponseEntity<OperationResponse> changeCustomerPassword(@RequestBody ChangePasswordRequest registerRequest) {
        return new ResponseEntity<>(userService.changeUserPassword(registerRequest), HttpStatus.OK);
    }

}
