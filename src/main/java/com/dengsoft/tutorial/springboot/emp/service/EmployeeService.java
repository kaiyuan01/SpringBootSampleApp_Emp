package com.dengsoft.tutorial.springboot.emp.service;

import java.util.List;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;

public interface EmployeeService {
	public List<Employee> retrieveEmployees();

	public Employee getEmployee(Long employeeId);

	public Employee getEmployee(String name);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Long employeeId);

	public void updateEmployee(Employee employee);
}
