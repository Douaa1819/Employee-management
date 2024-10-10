package org.employeemanagement.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super("Invalid input: " + message);
    }
}
