package org.azfar.vatcalculator.exceptions;

public class LoadException extends RuntimeException{
    public LoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
