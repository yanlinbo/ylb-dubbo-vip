package com.tuling.service;

import org.springframework.stereotype.Service;

import com.tuling.domain.User;
@Service
public class UserService {

	public User getUser(String uid) {
		User user = new User();
		user.setUid(uid);
		user.setUsername("yanlinbo");
		return user;
	}
	
}
