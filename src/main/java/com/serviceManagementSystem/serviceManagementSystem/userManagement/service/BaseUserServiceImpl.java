package com.serviceManagementSystem.serviceManagementSystem.userManagement.service;


import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.*;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.ChangePasswordRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.request.RegisterStaffRequest;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.LoginResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.dtos.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.model.BaseUser;
import com.serviceManagementSystem.serviceManagementSystem.userManagement.data.repository.BaseUserRepository;
import com.serviceManagementSystem.serviceManagementSystem.utils.OperationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RequiredArgsConstructor
@Service
@Slf4j
public class BaseUserServiceImpl implements BaseUserService {

    private final BaseUserRepository userRepository;


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
                .orElseThrow(EmailAlreadyExistsException::new);
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
                .orElseThrow(EmailAlreadyExistsException::new);
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
        if (!userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserNotFoundException();
        }
        if (!userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserNotFoundException();
        }
        BaseUser foundUser = userRepository.findByEmail(registerRequest.getEmail())
                .orElseThrow(EmailAlreadyExistsException::new);
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
        if (!userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UserNotFoundException();
        }
        BaseUser foundUser = userRepository.findByEmail(registerRequest.getEmail())
                .orElseThrow(EmailAlreadyExistsException::new);
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            throw new InvalidPasswordException();
        }
        foundUser.setPassword(hashPassword(registerRequest.getPassword()));
        userRepository.save(foundUser);
        return OperationResponse.builder()
                .status("SUCCESS")
                .build();
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
