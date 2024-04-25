package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceNotFoundException extends ServiceManagementException {

    public ServiceNotFoundException() {
        this("Service not found");
    }

    public ServiceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
