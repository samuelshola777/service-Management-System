package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ServiceManagementExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceManagementException.class)
    public ResponseEntity<ServiceManagementExceptionResponse> exceptionHandler(ServiceManagementException serviceManagementException) {
        ServiceManagementExceptionResponse response = ServiceManagementExceptionResponse.builder()
                .message(serviceManagementException.getMessage())
                .status(serviceManagementException.getStatus())
                .data(serviceManagementException.getData())
                .build();
        return new ResponseEntity<>(response, serviceManagementException.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode statusCode,
            @NonNull WebRequest request) {

        Map<String, String> data = new HashMap<>();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            data.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ServiceManagementExceptionResponse response = ServiceManagementExceptionResponse.builder()
                .data(data)
                .message("Bad request")
                .status(status)
                .build();

        return new ResponseEntity<>(response, status);
    }

}
