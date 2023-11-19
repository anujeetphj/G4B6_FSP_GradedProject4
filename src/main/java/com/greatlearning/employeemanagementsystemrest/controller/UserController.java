package com.greatlearning.employeemanagementsystemrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagementsystemrest.entity.Role;
import com.greatlearning.employeemanagementsystemrest.entity.User;
import com.greatlearning.employeemanagementsystemrest.service.RoleService;
import com.greatlearning.employeemanagementsystemrest.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	  
	@PostMapping("/users")
	public void createUser(@RequestBody User user){
		userService.save(user);
	}
}