package com.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> createEmployee(List<Employee> employee);
	
	public Employee getEmployeeById(Long eid);
	
	public Employee updateEmployee(Long eid, Employee empDetails);
	
	public ResponseEntity<?> deleteEmployee(Long eid);
	
}
