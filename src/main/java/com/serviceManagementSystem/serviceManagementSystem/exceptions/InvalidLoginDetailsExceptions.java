package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLoginDetailsExceptions extends ServiceManagementException {

    public InvalidLoginDetailsExceptions() {
        this("Invalid login details");
    }

    public InvalidLoginDetailsExceptions(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }

}
