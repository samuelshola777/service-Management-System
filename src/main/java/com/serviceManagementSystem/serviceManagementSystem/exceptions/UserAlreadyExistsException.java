package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends ServiceManagementException {

    public UserAlreadyExistsException() {
        this("User already exists");
    }

    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }


}
