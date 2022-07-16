package com.tuling.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tuling.domain.User;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String createOrder() {
		User user = restTemplate.getForObject("http://localhost:8082/user/1", User.class);
		System.out.println("创建订单");
		return user.toString();
	}
}
