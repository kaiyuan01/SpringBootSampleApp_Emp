package com.dengsoft.tutorial.springboot.emp.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = true, name="fname")
	private String fname;
	
	@Column(nullable = false)
	private String lname;

	private String address;
	
	@Column(nullable = false, name="dept")
	private Long dept;

	public Employee() {
	}

	public Employee(Long id, String fname, String lname, String address, Long deptId) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.dept = deptId;
	}

	public Employee(String fname, String lname, String address, Long deptId) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.dept = deptId;
	}

	// standard setters and getters
	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + fname + '\'' + ", address=" + address + '}';
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dept
	 */
	public Long getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Long deptid) {
		this.dept = deptid;
	}
}