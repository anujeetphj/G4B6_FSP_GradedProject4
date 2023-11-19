package com.greatlearning.employeemanagementsystemrest.service;

import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.User;

@Service
public interface UserService {
	
	public void save(User theUser);
}