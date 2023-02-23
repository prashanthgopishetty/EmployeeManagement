package com.labcorp.demo.dto;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.labcorp.demo.model.Employee;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }
}
