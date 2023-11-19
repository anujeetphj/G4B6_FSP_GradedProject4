package com.greatlearning.employeemanagementsystemrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystemrest.entity.User;
import com.greatlearning.employeemanagementsystemrest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//return userJpaRepository.save(user);
		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(this.passwordEncoder.encode(user.getPassword()));

		user.getRoles().forEach(role->newUser.addRole(role));
		
		userRepository.save(newUser);
	}
}

