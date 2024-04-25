package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends ServiceManagementException {

    public EmailAlreadyExistsException() {
        this("User already exists");
    }

    public EmailAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }


}
