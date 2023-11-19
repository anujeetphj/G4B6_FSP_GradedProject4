package com.greatlearning.employeemanagementsystemrest.service;

import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.Role;

@Service
public interface RoleService {
	
	public void save(Role theRole);
}