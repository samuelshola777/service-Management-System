package com.serviceManagementSystem.serviceManagementSystem.appUser.service.implementatio;

import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.LoginRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.request.RegisterRequest;
import com.serviceManagementSystem.serviceManagementSystem.appUser.DTO.response.RegisterResponse;
import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.AppUser;
import com.serviceManagementSystem.serviceManagementSystem.appUser.data.repository.AppUserRepository;
import com.serviceManagementSystem.serviceManagementSystem.appUser.service.interfaces.AppUserService;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.EmailAlreadyExistException;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.IncorrectPasswordException;
import com.serviceManagementSystem.serviceManagementSystem.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppUserServiceIMPL implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public AppUser registerAppUser(RegisterRequest request) {
    if (appUserRepository.existsEmail(request.getEmail())) throw new EmailAlreadyExistException();
        AppUser appUser = new AppUser();
        appUser.setEmail(request.getEmail());
        appUser.setRole(request.getRole());
        appUser.setPassword(request.getPassword());
        appUser.setFullName(request.getFullName());
      return   appUserRepository.save(appUser);

    }



    @Override
    public RegisterResponse loginAppUser(LoginRequest request) {
        AppUser foundAppUser = findAppUserByEmail(request.getEmail());
        if (!foundAppUser.getPassword().equalsIgnoreCase(request.getPassword()))
            throw new IncorrectPasswordException("incorrect password");
        return new RegisterResponse("login successful");
    }

    @Override
    public RegisterResponse logOutAppUser(LoginRequest request) {
        AppUser foundAppUser = findAppUserByEmail(request.getEmail());
        if (!foundAppUser.getPassword().equalsIgnoreCase(request.getPassword()))
            throw new IncorrectPasswordException("incorrect password");
        return new RegisterResponse("logout successful");
    }

    private AppUser findAppUserByEmail(String email) {
        AppUser foundAppUser = appUserRepository.findByEmail(email);
        if (foundAppUser == null) {
        throw new UserNotFoundException("user with the email "+email+" not found");

    }
        return foundAppUser;
    }


}
