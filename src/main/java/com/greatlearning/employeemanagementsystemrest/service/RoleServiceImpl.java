package com.greatlearning.employeemanagementsystemrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.Role;
import com.greatlearning.employeemanagementsystemrest.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Transactional
	public void save(Role theRole) {

		roleRepository.save(theRole);
	}
}
