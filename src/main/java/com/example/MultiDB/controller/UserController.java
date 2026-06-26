package com.example.MultiDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MultiDB.primary.User;
import com.example.MultiDB.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String getUserInfo() {
		
		User user = new User();
		user.setId(1L);
		userService.getUserInfo(user);
		return user.getName() + " " + user.getEmail();
	}
	
	@GetMapping("/saveuser")
	public String saveUserInfo() {
		
		User user = new User();
		user.setId(1L);
		user.setName("John Doe");
		user.setEmail("john@gmail.com");
		
		userService.saveUser(user);
		return "User Info";
	}
	
	
}
