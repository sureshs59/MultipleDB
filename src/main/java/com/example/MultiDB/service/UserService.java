package com.example.MultiDB.service;

import org.springframework.stereotype.Service;

import com.example.MultiDB.primary.User;
import com.example.MultiDB.primary.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Object saveUser(User user) {
		return userRepository.saveUser(user);
	}
	
	public Object getUserInfo(User user) {
		return userRepository.findUser(user);
	}
}
