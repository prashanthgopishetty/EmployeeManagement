package com.labcorp.demo.exception;
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(Long id) {
        super(String.valueOf(id));
    }

    public EmployeeNotFoundException(Long id, Throwable cause) {
        super(String.valueOf(id), cause);
    }

}
