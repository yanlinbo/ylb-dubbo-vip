package com.tuling.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tuling.domain.User;
import com.tuling.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping("/user/{uid}") 
	public User getUser(@PathVariable("uid") String uid) { 
		return userService.getUser(uid);
	}
}
