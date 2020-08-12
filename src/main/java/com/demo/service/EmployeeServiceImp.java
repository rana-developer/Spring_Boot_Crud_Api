package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		System.out.println("Imp v1");
		return employeeRepository.findAll();
	}

    @Override
    public List<Employee> createEmployee(List<Employee> employee) {
        List<Employee> ee = new ArrayList<>();
        for(Employee emp : employee)
        {
            ee.add(employeeRepository.save(emp));
        }
        return ee;
    }

	@Override
	public Employee getEmployeeById(Long empid) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empid));
	}

	@Override
	public Employee updateEmployee(Long empid, Employee empDetails) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empid));

		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());

		Employee updatedEmp = employeeRepository.save(employee);
		return updatedEmp;
	}

	@Override
	public ResponseEntity<?> deleteEmployee(Long empid) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(empid)
				.orElseThrow( ()-> new ResourceNotFoundException("Employee", "id", empid) );
		
		employeeRepository.delete(employee);
		return ResponseEntity.ok().build();
	}

}
