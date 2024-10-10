package org.employeemanagement.exception;

public class UnauthorizedOperationException extends RuntimeException {
    public UnauthorizedOperationException(String operation) {
        super("You are not authorized to perform the operation: " + operation);
    }
}