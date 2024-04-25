package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends ServiceManagementException {

    public InvalidPasswordException() {
        this("Passwords don't match");
    }

    public InvalidPasswordException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

}