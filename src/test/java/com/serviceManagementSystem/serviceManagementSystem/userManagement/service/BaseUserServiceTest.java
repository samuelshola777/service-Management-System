package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;

import com.serviceManagementSystem.serviceManagementSystem.exceptions.EmailAlreadyExistsException;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.InvalidLoginDetailsExceptions;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.UserNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BaseUserServiceTest {
    @Autowired
    private BaseUserService baseUserService;

    private RegisterRequest registerRequest;
    private LoginRequest loginRequest;


    @BeforeEach
    void setUp() {
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("adeolaFool@gmail.com");
        registerRequest.setPassword("password");
        registerRequest.setFirstName("adeola");
        registerRequest.setLastName("fool");


        loginRequest = new LoginRequest();

    }

    @Test
    void registerCustomer() {
        assertDoesNotThrow(()->{
            baseUserService.registerCustomer(registerRequest);
        });
    }
    @Test
    void registerCustomerWithAnExistingEmail() {
        assertThrows(EmailAlreadyExistsException.class, ()->{
            baseUserService.registerCustomer(registerRequest);
            baseUserService.registerCustomer(registerRequest);
        });
    }

    @Test
    void loginCustomer() {
        loginRequest.setEmail("adeolaFool@gmail.com");
        loginRequest.setPassword("password");

        assertThrows(Exception.class, ()->{
            baseUserService.loginCustomer(loginRequest);
        });
    }

    @Test
    void loginCustomerWithWrongDetails() {
        loginRequest.setEmail("aadeolaFool@gmail.com");
        loginRequest.setPassword("wrong password");

       assertDoesNotThrow( ()->{
            baseUserService.loginCustomer(loginRequest);
        });
        assertThrows(InvalidLoginDetailsExceptions.class, ()->{
            baseUserService.loginCustomer(loginRequest);
        });
    }

    @Test
    void registerStaff() {
    }

    @Test
    void loginStaff() {
    }

    @Test
    void updateUserDetails() {
    }

    @Test
    void changeUserPassword() {
    }

    @Test
    void deleteUserAccount() {
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void getCustomerUserByEmail() {
    }

    @Test
    void getStaffUserByEmail() {
    }
}