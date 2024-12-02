package com.example.SpringBootCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBootCrud.entity.Employee;
import com.example.SpringBootCrud.service.Emp_Service;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Emp_Controller {

	@Autowired
	private Emp_Service service;

	// Add a new employee
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	// Get employees by status
	@GetMapping("/status/{status}")
	public List<Employee> getEmployeesByStatus(@PathVariable String status) {
		return service.getEmployeesByStatus(status);
	}

	// Get employee by ID
	@GetMapping("/{eid}")
	public Employee getEmployeeById(@PathVariable int eid) {
		return service.getEmployeeById(eid);
	}

	// Delete employee by ID
	@DeleteMapping("/deleteemployeebyid/{eid}")
	public boolean deleteEmployeeById(@PathVariable int eid) {
		boolean msg=service.deleteEmployee(eid);
		return msg;
	}

	@GetMapping("/getname/{name}")
	public List<Employee> getEmployeesByName(@PathVariable String name) {
		return service.getEmployeesByName(name);
	}

	@PutMapping("/updatedEmployeeByName/{name}")
	public Employee updatedEmployeeByName(@RequestBody Employee e, @PathVariable String name) {
		return service.updatedEmployeeByName(e, name);
	}
	



	
	
}
