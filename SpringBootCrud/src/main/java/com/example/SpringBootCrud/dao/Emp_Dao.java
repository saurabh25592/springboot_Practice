package com.example.SpringBootCrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.SpringBootCrud.entity.Employee;

import java.util.List;

@Repository
public class Emp_Dao {

	@Autowired
	SessionFactory factory;

	// Save an employee
	public String saveEmployee(Employee e) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(e);
		transaction.commit();
		session.close();
		return "Employee data saved successfully.";
	}

	// Get employees by status
	public List<Employee> getEmployeesByStatus(String status) {
		Session session = factory.openSession();
		List<Employee> employees = session.createQuery("FROM Employee WHERE status = :status", Employee.class)
				.setParameter("status", status).getResultList();
		session.close();
		return employees;
	}

	// Get employee by ID
	public Employee getEmployeeById(int eid) {
		Session session = factory.openSession();
		Employee employee = session.get(Employee.class, eid);
		session.close();
		return employee;
	}

	// Delete an employee by ID
	public boolean deleteEmployee(int eid) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, eid);
		if (employee != null) {
			session.delete(employee);
			transaction.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	public List<Employee> getEmployeeByName(String name) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Employee> query = (List<Employee>) session.createQuery("FROM Employee WHERE name := name", Employee.class)
				.setParameter("name", name).getResultList();
		session.close();
		return query;

	}

	public String updatecountryname(Employee e, int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = session.get(Employee.class, id);
		emp.setName(e.getName());
		emp.setPhoneno(e.getPhoneno());
		emp.setDepartmentit(e.getDepartmentit());
		emp.setStatus(e.getStatus());

		session.merge(emp);
		transaction.commit();
		session.close();
		return "data is updated.............";
	}

	public Employee updatedEmployeeByName(Employee e, String name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee emp = session.get(Employee.class, name);
		emp.setStatus(e.getStatus());
		emp.setDepartmentit(e.getDepartmentit());
		return session.merge(emp);

	}

	
	
}
