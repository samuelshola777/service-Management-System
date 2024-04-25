package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistException extends GlobalGeneralException{
    private String message;

    public EmailAlreadyExistException(){
        this("email already exists");
    }
    public EmailAlreadyExistException(String message) {
        super(message, HttpStatus.BAD_GATEWAY);
    }
}
