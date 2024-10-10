package org.employeemanagement.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(Long id) {
        super("The ID " + id + " was not found.");
    }
}