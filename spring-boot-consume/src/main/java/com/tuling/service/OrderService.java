package com.tuling.service;

import com.tuling.domain.User;
import com.tuling.domain.entity.SysUser;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

//import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

//	@Autowired
//	private RestTemplate restTemplate;
	
//	public String createOrder() {
//		User user = restTemplate.getForObject("http://localhost:8082/user/1", User.class);
//		System.out.println("创建订单");
//		return user.toString();
//	}

	/**
	 * 注意，这里不能注入实现类，或者实现类名称都会报错
	 */
	@DubboReference(url = "rest://localhost:2181", protocol = "rest")
	private UserService userService;

	public String createOrder() {
		User user = userService.getUser("1");
		System.out.println("创建订单");
		return user.toString();
	}

	public String getOrderUser() {
		SysUser sysUser = userService.getSysUser(1L);
		System.out.println("获取订单的用户");
		return sysUser.getUserName();
	}
}
