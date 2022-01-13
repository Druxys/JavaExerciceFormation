package com.exercice.formation.exception;

public class InvoiceAlreadyExistException extends RuntimeException{
    public InvoiceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvoiceAlreadyExistException(String message){super(message);}
}
