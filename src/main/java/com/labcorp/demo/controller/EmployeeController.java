package com.labcorp.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labcorp.demo.config.StartupRunner;
import com.labcorp.demo.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private StartupRunner startupRunner;

	@GetMapping("/test")
	public String test() {
		return "hell world";
	}

	@GetMapping("/all")
	public Collection<Employee> getAllEmployees() {
		return startupRunner.getEmployees();
	}
	
	@PostMapping("/{empId}/work/{days}")
    public ResponseEntity<?> workEmployee(@PathVariable int empId, @PathVariable int days) {
        Employee employee = startupRunner.getEmployee(empId);
        employee.work(days);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{empId}/vacation/{days}")
    public ResponseEntity<?> takeVacationHourlyEmployee(@PathVariable int empId, @PathVariable float days) {
        Employee employee = startupRunner.getEmployee(empId);
        employee.takeVacation(days);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int empId){
    	Employee employee = startupRunner.getEmployee(empId);
    	return ResponseEntity.ok(employee);
    }
   

    
}
