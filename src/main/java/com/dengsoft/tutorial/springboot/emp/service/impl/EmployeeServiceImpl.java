/**
 * 
 */
package com.dengsoft.tutorial.springboot.emp.service.impl;

import java.util.List;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;
import com.dengsoft.tutorial.springboot.emp.service.EmployeeService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.dengsoft.tutorial.springboot.emp.db.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return optEmp.get();
	}

	// we assume last name is unique in our records, - for this exercise
	public Employee getEmployee(String lname) {
		Optional<Employee> optEmp = employeeRepository.findByLastName(lname);
		return optEmp.get();
	}
	
//	public Employee getEmployee(String name) {
//		// Optional<Employee> optEmp = findById(employeeId);
//		ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
//		Example<Employee> example = Example.of(Employee.from(null, "fred", "bloggs", null, null), caseInsensitiveExampleMatcher);
//
//		Optional<Employee> actual = employeeRepository.findOne(example);
//
//		return optEmp.get();
//	}

	public void saveEmployee(Employee employee) {
		logger.info("Employee object to be saved to DB: " + employee.toString());
		employeeRepository.save(employee);
	}

	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}