package com.labcorp.demo.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.labcorp.demo.model.Employee;
import com.labcorp.demo.model.HourlyEmployee;
import com.labcorp.demo.model.Manager;
import com.labcorp.demo.model.SalariedEmployee;

@Component
public class StartupRunner implements CommandLineRunner {
	private final Map<Long,Employee> employees = new HashMap<>();

	@Override
	public void run(String... args) throws Exception {
		// Create 10 instances of each type of employee and add them to the list
		for (int i = 0; i < 10; i++) {
			Employee hourlyEmployee = new HourlyEmployee("HourlyEmployee" + i);
			Employee salariedEmployee = new SalariedEmployee("SalariedEmployee" + i);
			Employee manager = new Manager("Manager" + i);
			employees.put(hourlyEmployee.getId(), hourlyEmployee);
			employees.put(salariedEmployee.getId(), salariedEmployee);
			employees.put(manager.getId(), manager);
		}

	}

	public Collection<Employee> getEmployees() {
		return employees.values();
	}
	
	public Employee getEmployee(long empId) {
		return employees.get(empId);
	}
}
