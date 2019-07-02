/**
 * 
 */
package com.dengsoft.tutorial.springboot.emp.db.repository;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * @author acer2root
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// same as: public Employee findByLastName(String lname);
	@Query("SELECT e FROM Employee e WHERE e.lname = ?1")
	public Optional<Employee> findByLastName(String lname); 

	}
