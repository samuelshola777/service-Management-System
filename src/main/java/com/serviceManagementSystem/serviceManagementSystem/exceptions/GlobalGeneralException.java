package com.serviceManagementSystem.serviceManagementSystem.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class GlobalGeneralException extends  RuntimeException{

    @Getter
    private HttpStatus status;

    @Getter
    private Map<String, String> data;

//    public GoChowExceptionn(){
//        this("Unable to process request");
//    }

    public GlobalGeneralException(String message){
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public GlobalGeneralException(String message, HttpStatus status){
        this(message, status, Map.of());
    }

    public GlobalGeneralException(String message, HttpStatus status, Map<String, String> data){
        super(message);
        this.status = status;
        this.data = data;
    }
}
