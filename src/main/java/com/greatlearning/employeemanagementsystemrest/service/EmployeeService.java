package com.greatlearning.employeemanagementsystemrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);
	
	public List<Employee> findByFirstName(String firstName);
	
	public List<Employee> sortByFirstName(String order);

	public void save(Employee theEmployee);

	public void deleteById(int theId);
}