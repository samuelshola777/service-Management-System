package com.serviceManagementSystem.serviceManagementSystem.exceptions;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ServiceManagementExceptionResponse {

    private HttpStatus status;

    private String message;

    private Map<String, String> data;

}
