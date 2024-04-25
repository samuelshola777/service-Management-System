package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class QuoteNotFoundException extends ServiceManagementException {

    public QuoteNotFoundException() {
        this("Quote not found");
    }

    public QuoteNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
