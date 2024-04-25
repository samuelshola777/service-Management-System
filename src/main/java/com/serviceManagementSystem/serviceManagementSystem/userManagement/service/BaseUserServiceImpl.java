package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;


import com.serviceManagementSystem.serviceManagementSystem.exceptions.*;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.*;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.SystemRole;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.repository.BaseUserRepository;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RequiredArgsConstructor
@Service
@Slf4j
public class BaseUserServiceImpl implements BaseUserService {

    private final BaseUserRepository userRepository;

    @Value("${FIRST_EMAIL}")
    private String FIRST_EMAIL;

    @Value("${PASSWORD_FOR_FIRST_STAFF}")
    private String PASSWORD_FOR_FIRST_STAFF;

    @PostConstruct
    private void createFirstStaff() {
        if (!userRepository.existsByEmailAndRole(FIRST_EMAIL, SystemRole.STAFF)) {
            BaseUser baseUser = BaseUser.builder()
                    .email(FIRST_EMAIL)
                    .password(hashPassword(PASSWORD_FOR_FIRST_STAFF))
                    .role(SystemRole.STAFF)
                    .build();
            userRepository.save(baseUser);
        }
    }


    @Override
    public RegisterResponse registerCustomer(RegisterRequest registerRequest) {
        if (userRepository.existsByEmailAndRole(registerRequest.getEmail(), SystemRole.CUSTOMER)) {
            throw new EmailAlreadyExistsException();
        }
        BaseUser baseUser = BaseUser.builder()
                .email(registerRequest.getEmail())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .password(hashPassword(registerRequest.getPassword()))
                .role(SystemRole.CUSTOMER)
                .build();
        BaseUser savedCustomer = userRepository.save(baseUser);
        return RegisterResponse.builder()
                .email(savedCustomer.getEmail())
                .firstName(savedCustomer.getFirstName())
                .lastName(savedCustomer.getLastName())
                .role(savedCustomer.getRole())
                .build();
    }

    @Override
    public LoginResponse loginCustomer(LoginRequest loginRequest) {
        BaseUser foundUser = userRepository.findByEmailAndRole(loginRequest.getEmail(), SystemRole.CUSTOMER)
                .orElseThrow(UserNotFoundException::new);
        String hashedPassword = hashPassword(loginRequest.getPassword());
        if (hashedPassword.equals(foundUser.getPassword())) {
            return LoginResponse.builder()
                    .email(foundUser.getEmail())
                    .role(foundUser.getRole())
                    .build();
        } else {
            throw new InvalidLoginDetailsExceptions();
        }
    }

    @Override
    public RegisterResponse registerStaff(RegisterStaffRequest staffRequest) {
        if (userRepository.existsByEmailAndRole(staffRequest.getEmail(), SystemRole.STAFF)) {
            throw new EmailAlreadyExistsException();
        }
        BaseUser baseUser = BaseUser.builder()
                .email(staffRequest.getEmail())
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .password(hashPassword(staffRequest.getPassword()))
                .role(SystemRole.STAFF)
                .build();
        BaseUser savedStaff = userRepository.save(baseUser);
        return RegisterResponse.builder()
                .email(savedStaff.getEmail())
                .firstName(savedStaff.getFirstName())
                .lastName(savedStaff.getLastName())
                .role(savedStaff.getRole())
                .build();
    }

    @Override
    public LoginResponse loginStaff(LoginRequest loginRequest) {
        BaseUser foundUser = userRepository.findByEmailAndRole(loginRequest.getEmail(), SystemRole.STAFF)
                .orElseThrow(UserNotFoundException::new);
        String hashedPassword = hashPassword(loginRequest.getPassword());
        if (hashedPassword.equals(foundUser.getPassword())) {
            return LoginResponse.builder()
                    .email(foundUser.getEmail())
                    .role(foundUser.getRole())
                    .build();
        } else {
            throw new InvalidLoginDetailsExceptions();
        }
    }

    @Override
    public RegisterResponse updateUserDetails(RegisterRequest registerRequest) {
        BaseUser foundUser = userRepository.findByEmail(registerRequest.getEmail())
                .orElseThrow(UserNotFoundException::new);
        foundUser.setFirstName(registerRequest.getFirstName());
        foundUser.setLastName(registerRequest.getLastName());
        foundUser.setEmail(registerRequest.getEmail());
        BaseUser updatedUser = userRepository.save(foundUser);
        return RegisterResponse.builder()
                .email(updatedUser.getEmail())
                .firstName(updatedUser.getFirstName())
                .lastName(updatedUser.getLastName())
                .role(updatedUser.getRole())
                .build();
    }

    @Override
    public OperationResponse changeUserPassword(ChangePasswordRequest registerRequest) {
        BaseUser foundUser = userRepository.findByEmail(registerRequest.getEmail())
                .orElseThrow(UserNotFoundException::new);
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            throw new InvalidPasswordException();
        }
        foundUser.setPassword(hashPassword(registerRequest.getPassword()));
        userRepository.save(foundUser);
        return OperationResponse.builder()
                .status("SUCCESS")
                .build();
    }

    @Override
    public OperationResponse deleteUserAccount(DeleteRequest deleteRequest) {
        BaseUser foundUser = getUserByEmail(deleteRequest.getEmail());
        String hashedPassword = hashPassword(deleteRequest.getPassword());
        if (hashedPassword.equals(foundUser.getPassword())) {
            userRepository.delete(foundUser);
            return OperationResponse.builder()
                    .status("SUCCESSFUL")
                    .build();
        } else {
            throw new InvalidLoginDetailsExceptions("User cannot be deleted");
        }
    }

    @Override
    public BaseUser getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public BaseUser getCustomerUserByEmail(String email) {
        return userRepository.findByEmailAndRole(email, SystemRole.CUSTOMER)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public BaseUser getStaffUserByEmail(String email) {
        return userRepository.findByEmailAndRole(email, SystemRole.STAFF)
                .orElseThrow(UserNotFoundException::new);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("Error:  ", e);
            throw new ServiceManagementException("Error hashing password");
        }
    }
}
