package com.conectapro.conectapro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectapro.conectapro.entity.UserEntity;
import com.conectapro.conectapro.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> findAllUsers() {
		
		List<UserEntity> users = this.userRepository.findAll();
		
		return users;
		
	}
	
}
