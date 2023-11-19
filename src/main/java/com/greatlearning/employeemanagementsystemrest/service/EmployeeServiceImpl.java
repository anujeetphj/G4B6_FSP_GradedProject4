package com.greatlearning.employeemanagementsystemrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.Employee;
import com.greatlearning.employeemanagementsystemrest.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> findAll() {

		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

	@Transactional
	public Employee findById(int id) {

		Employee employee = employeeRepository.findById(id).get();

		return employee;
	}

	@Transactional
	public void save(Employee theEmployee) {

		employeeRepository.save(theEmployee);
	}

	@Transactional
	public void deleteById(int id) {

		employeeRepository.deleteById(id);
	}
	
	@Transactional
	public List<Employee> findByFirstName(String firstName) {

		List<Employee> employees = employeeRepository.findByFirstName(firstName);

		return employees;
	}
	
	@Transactional
	public List<Employee> sortByFirstName(String order) {
		
		Sort sort;
		
		if (order == "desc") {			
			sort = Sort.by(Sort.Direction.DESC, "firstName");
		} else {
			sort = Sort.by(Sort.Direction.ASC, "firstName");
		}
		
		List<Employee> employees = employeeRepository.findAll(sort);

		return employees;
	}
}