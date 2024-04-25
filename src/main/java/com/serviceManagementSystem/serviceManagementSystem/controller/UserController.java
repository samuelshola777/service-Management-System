package com.serviceManagementSystem.serviceManagementSystem.controller;


import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.DeleteRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.services.interfaces.BaseUserService;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/inviteStaff")
    public ResponseEntity<OperationResponse> inviteStaff(@RequestParam String email) {
        return new ResponseEntity<>(userService.inviteStaff(email), HttpStatus.OK);
    }

    @PostMapping("/registerStaff")
    public ResponseEntity<RegisterResponse> registerStaff(@RequestBody RegisterRequest staffRequest) {
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

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<OperationResponse> deleteUserAccount(@RequestBody DeleteRequest deleteRequest) {
        return new ResponseEntity<>(userService.deleteUserAccount(deleteRequest), HttpStatus.OK);
    }

}
