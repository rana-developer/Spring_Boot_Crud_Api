package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;

import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImp;
import com.demo.service.EmployeeServiceImp2;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeServiceImp2")
	EmployeeService employeeService;
	
	
	@GetMapping("/allemp")
	public List<Employee> getAllEmployees(){
		System.out.println("calling 1 api");
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/postemp")
	public List<Employee> createEmployee(@Valid @RequestBody List<Employee> employee) {
		
		return employeeService.createEmployee(employee);
		
	}
	
	@GetMapping("/getemp/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long empid) {
		
		return employeeService.getEmployeeById(empid);
		
	}
	@PutMapping("/putemp/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid@RequestBody Employee empDetails ) {
				
		return employeeService.updateEmployee(empid, empDetails);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value="id") Long empid){
		
		return employeeService.deleteEmployee(empid);
	}
}
