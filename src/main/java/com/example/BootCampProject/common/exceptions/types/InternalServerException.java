package com.example.BootCampProject.common.exceptions.types;


public class InternalServerException extends RuntimeException{
    public InternalServerException(String message)
    {
        super(message);
    }
}
