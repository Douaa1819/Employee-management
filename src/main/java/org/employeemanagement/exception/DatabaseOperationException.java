package org.employeemanagement.exception;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(String message) {
        super("A database error occurred: " + message);
    }

    public DatabaseOperationException(String message, Throwable cause) {
        super("A database error occurred: " + message, cause);
    }
}