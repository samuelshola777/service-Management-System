package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class UnableToRescheduleException extends ServiceManagementException {

    public UnableToRescheduleException() {
        this("Appointment has been rescheduled too many times!");
    }

    public UnableToRescheduleException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

}
