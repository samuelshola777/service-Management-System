package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import org.springframework.http.HttpStatus;

public class AppointmentNotFoundException extends ServiceManagementException {

    public AppointmentNotFoundException() {
        this("Appointment not found");
    }

    public AppointmentNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}