package com.tuling.service;

import com.tuling.domain.User;
import com.tuling.domain.entity.SysUser;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.ws.rs.PathParam;


public interface UserService {

	public User getUser(String uid);

	public SysUser getSysUser(Long userId);
	
}
