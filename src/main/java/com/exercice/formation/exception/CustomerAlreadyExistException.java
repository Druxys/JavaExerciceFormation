package com.exercice.formation.exception;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerAlreadyExistException(String message){super(message);}
}
