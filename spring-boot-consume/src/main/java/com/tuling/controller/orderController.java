package com.tuling.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuling.service.OrderService;

@RestController
public class orderController {

	@Resource
	private OrderService orderService;
	 
		@GetMapping("/createOrder") 
		public String createOrder() { 
			return orderService.createOrder();
	 }
}
