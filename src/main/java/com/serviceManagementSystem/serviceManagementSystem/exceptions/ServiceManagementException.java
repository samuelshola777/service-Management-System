package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ServiceManagementException extends RuntimeException {

    private final HttpStatus status;

    private final Map<String, String> data;

    public ServiceManagementException() {
        this("Unable to process request");
    }

    public ServiceManagementException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceManagementException(String message, HttpStatus status) {
        this(message, status, Map.of());
    }

    public ServiceManagementException(String message, HttpStatus status, Map<String, String> data) {
        super(message);
        this.status = status;
        this.data = data;
    }

}
