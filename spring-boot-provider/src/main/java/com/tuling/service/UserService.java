package com.tuling.service;

import com.tuling.domain.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;


public interface UserService {

	public User getUser(String uid);
	
}
