package com.dengsoft.tutorial.springboot.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;
import com.dengsoft.tutorial.springboot.emp.service.EmployeeService;
import com.dengsoft.tutorial.springboot.emp.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeRestController {
  
 Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	    
 @Autowired
 private EmployeeService employeeService;
  
 public void setEmployeeService(EmployeeService employeeService) {
  this.employeeService = employeeService;
 }
 
 @GetMapping("/api/employees")
 public List<Employee> getEmployees() {
  List<Employee> employees = employeeService.retrieveEmployees();
  return employees;
 }
  
 @GetMapping("/api/employees/{id}")
 public Employee getEmployee(@PathVariable(name="id")Long employeeId) {
  return employeeService.getEmployee(employeeId);
 }
  
 @GetMapping("/api/employees/lname/{name}")
 public Employee getEmployee(@PathVariable(name="name")String name) {
  return employeeService.getEmployee(name);
 }
 
 @PostMapping("/api/employees")
 public void saveEmployee(@RequestBody Employee employee){
  logger.info("IN Rest Controller: Employee object to be passed to saveEmployee: " + employee.toString());
  employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully");
 }
  
 @DeleteMapping("/api/employees/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
  
 @PutMapping("/api/employees/{employeeId}")
 public void updateEmployee(@RequestBody Employee employee,
   @PathVariable(name="employeeId")Long employeeId){
  Employee emp = employeeService.getEmployee(employeeId);
  if(emp != null){
   employeeService.updateEmployee(employee);
  }
   
 }
 
}