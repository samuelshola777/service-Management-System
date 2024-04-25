package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends GlobalGeneralException{

    private String message;

    public IncorrectPasswordException(){
        this("incorrect password");
    }
    public IncorrectPasswordException(String message) {
        super(message, HttpStatus.BAD_GATEWAY);
    }
}
