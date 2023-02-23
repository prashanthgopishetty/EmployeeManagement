package com.labcorp.demo.dto;

import java.util.List;

import com.labcorp.demo.model.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();
    void save(Employee employee);
}