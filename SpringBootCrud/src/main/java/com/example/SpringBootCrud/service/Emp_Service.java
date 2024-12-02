package com.example.SpringBootCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootCrud.dao.Emp_Dao;
import com.example.SpringBootCrud.entity.Employee;

import java.util.List;

@Service
public class Emp_Service {

	@Autowired
	Emp_Dao dao;

	// Save an employee
	public String saveEmployee(Employee e) {
		return dao.saveEmployee(e);
	}

	// Get employees by status
	public List<Employee> getEmployeesByStatus(String status) {
		return dao.getEmployeesByStatus(status);
	}

	// Get employee by ID
	public Employee getEmployeeById(int eid) {
		return dao.getEmployeeById(eid);
	}

	// Delete an employee by ID
	public Boolean deleteEmployee(int eid) {
		boolean msg = dao.deleteEmployee(eid);
		return msg;
	}

	// get Employee by Name
	public List<Employee> getEmployeesByName(String name) {
		return dao.getEmployeeByName(name);
	}

	public Employee updatedEmployeeByName(Employee e, String name) {
		return dao.updatedEmployeeByName(e, name);
	}

}
