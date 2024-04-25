package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;

import com.serviceManagementSystem.serviceManagementSystem.exceptions.EmailAlreadyExistsException;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.InvalidLoginDetailsExceptions;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.UserNotFoundException;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterStaffRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BaseUserServiceTest {
    @Autowired
    private BaseUserService baseUserService;
    private RegisterStaffRequest staffRequest;
    private RegisterStaffRequest staffRequest1;
   private ChangePasswordRequest   changeUserPassword;
    private LoginRequest loginRequest1;
    private LoginRequest loginRequest2;

    private RegisterRequest registerRequest;
    private RegisterRequest updateUserDetails;
    private LoginRequest loginRequest;


    @BeforeEach
    void setUp() {
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("adeolaFool@gmail.com");
        registerRequest.setPassword("password");
        registerRequest.setFirstName("adeola");
        registerRequest.setLastName("fool");


        loginRequest = new LoginRequest();
        loginRequest2 = new LoginRequest();
        staffRequest1 = new RegisterStaffRequest();


       staffRequest = new RegisterStaffRequest();
       staffRequest.setEmail("uncleNewStaff@gmail.com");
       staffRequest.setPassword("password");
       staffRequest.setFirstName("uncleNewStaffFirst");
       staffRequest.setLastName("uncleNewStaffLast");

       staffRequest1 = new RegisterStaffRequest();

       loginRequest1 = new LoginRequest();
       loginRequest1.setPassword("password");
       loginRequest1.setEmail("uncleNewStaff@gmail.com");

       updateUserDetails = new RegisterRequest();
       updateUserDetails.setLastName("elomMosk");
       updateUserDetails.setFirstName("goatNation");
       updateUserDetails.setEmail("uncleNewStaff@gmail.com");


     changeUserPassword = new ChangePasswordRequest();
        changeUserPassword.setEmail("uncleNewStaff@gmail.com");
        changeUserPassword.setPassword("newPassword");
        changeUserPassword.setConfirmPassword("newPassword");
    }


    @Test
    @Disabled
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

        assertDoesNotThrow( ()->{
            baseUserService.loginCustomer(loginRequest);
        });
    }

    @Test
    void loginCustomerWithWrongDetails() {
        loginRequest.setEmail("adeolaFool@gmail.com");
        loginRequest.setPassword("wrong password");

        assertThrows(InvalidLoginDetailsExceptions.class, ()->{
            baseUserService.loginCustomer(loginRequest);
        });
    }

    @Test
    void registerStaff() {
        assertDoesNotThrow(()->{
            baseUserService.registerStaff(staffRequest);
        });
    }
    @Test
    void testThatWeCanRegisterStaffWithCustomerEmail() {

        staffRequest1.setEmail("adeolaFool@gmail.com");
        staffRequest1.setPassword("password");
        staffRequest1.setFirstName("uncleNewStaffFirst");
        staffRequest1.setLastName("uncleNewStaffLast");
        assertThrows(EmailAlreadyExistsException.class, ()->{
            baseUserService.registerStaff(staffRequest1);
        });
    }

    @Test
    void loginStaff() {
       assertDoesNotThrow(()->{
           baseUserService.loginStaff(loginRequest1);
       });
    }
 @Test
    void testThatCustomerCantLoginAsStaff() {
        loginRequest2.setEmail("adeolaFool@gmail.com");
        loginRequest2.setPassword("password");
        assertThrows(UserNotFoundException.class,() -> {
            baseUserService.loginStaff(loginRequest2);
        });
    }

    @Test
    void updateUserDetails() {
        RegisterResponse response = baseUserService.updateUserDetails(updateUserDetails);

        assertEquals("elomMosk",response.getLastName());
        assertEquals("goatNation",response.getFirstName());
    }

    @Test
    void changeUserPassword() {
        OperationResponse response = baseUserService.changeUserPassword(changeUserPassword);
        assertEquals("SUCCESS", response.getStatus());
    }

    @Test
    void deleteUserAccount() {
    }

    @Test
    void getUserByEmail() {

        BaseUser foundUser = baseUserService.getCustomerUserByEmail("adeolaFool@gmail.com");
      assertEquals("adeola", foundUser.getFirstName());
    }

    @Test
    void getCustomerUserByEmail() {
        assertNotNull(baseUserService.getCustomerUserByEmail("adeolaFool@gmail.com"));
    }

    @Test
    void getStaffUserByEmail() {
        assertNotNull(baseUserService.getStaffUserByEmail("uncleNewStaff@gmail.com"));
    }
}