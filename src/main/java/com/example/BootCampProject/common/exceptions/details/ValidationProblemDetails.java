package com.example.BootCampProject.common.exceptions.details;


import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails{

    private Map<String,String> errors;

    public ValidationProblemDetails(){
        setTitle("Validation Exception");
        setType("http://acunmedya.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
        setDetail("Validation Rule Problems");
    }
}
