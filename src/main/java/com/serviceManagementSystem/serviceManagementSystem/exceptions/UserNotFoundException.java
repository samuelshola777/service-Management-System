package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends GlobalGeneralException {
    private String message;

    public UserNotFoundException(){
        this("User not found");
    }
    public UserNotFoundException(String message) {
        super(message, HttpStatus.BAD_GATEWAY);
    }
}
