package com.greatlearning.employeemanagementsystemrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagementsystemrest.entity.Employee;
import com.greatlearning.employeemanagementsystemrest.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> listEmployees() {
		
		try {
			
			List<Employee> theEmployees = employeeService.findAll();
						
			if (theEmployees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(theEmployees, HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/employees/search/{firstName}")
	public ResponseEntity<List<Employee>> searchEmployees(@RequestParam("firstName") String firstName) {
		
		try {
			
			List<Employee> theEmployees = employeeService.findByFirstName(firstName);
			
			
			if (theEmployees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(theEmployees, HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/employees/sort/{order}")
	public ResponseEntity<List<Employee>> sortEmployees(@RequestParam("order") String order) {
		
		try {
			
			List<Employee> theEmployees = employeeService.sortByFirstName(order);
			
			
			if (theEmployees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(theEmployees, HttpStatus.OK);
		} catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
    
		Employee employeeData = employeeService.findById(id);

		if (employeeData.equals(null)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(employeeData, HttpStatus.OK);
		}
    }

	@PostMapping("/employees/save")
	public ResponseEntity<Employee> saveEmployee(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email) {
		
		try {
			
			System.out.println(id);
			Employee theEmployee;
			
			if(id!=0)
			{
				theEmployee=employeeService.findById(id);
				theEmployee.setFirstName(firstName);
				theEmployee.setLastName(lastName);
				theEmployee.setEmail(email);
			}
			
			else
				theEmployee=new Employee(firstName, lastName, email);
			// save the Employee Record
			employeeService.save(theEmployee);
			
			return new ResponseEntity<>(theEmployee, HttpStatus.OK);
		
		} catch (Exception e) {
		    
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PostMapping("/employees/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int theId) {
		
		try {
			// delete the Employee Record
			employeeService.deleteById(theId);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}  catch (Exception e) {
		    
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}