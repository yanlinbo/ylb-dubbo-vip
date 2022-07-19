package com.tuling.service.impl;

import com.alibaba.fastjson.JSON;
import com.tuling.domain.User;
import com.tuling.domain.entity.SysUser;
import com.tuling.mapper.SysUserMapper;
import com.tuling.service.UserService;
import com.tuling.utils.RedisUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


//@Service
@DubboService
@Path("/user")
@Produces
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private RedisUtils redisUtils;

	@GET
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("uid") String uid) {
		User user = new User();
		user.setUid(uid);
		user.setUsername("yanlinbo");
		return user;
	}

	/**
	 * 通过用户ID查询用户
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SysUser getSysUser(@PathParam("userId") Long userId) {

		SysUser sysUser = (SysUser)redisUtils.getValue(String.valueOf(userId));
		if(sysUser == null){
			sysUser = sysUserMapper.selectUserById(userId);
			if(sysUser != null){
				redisUtils.setValue(String.valueOf(userId), JSON.toJSONString(sysUser));
			}
		}
		return sysUser;
	}


	/**
	 * 校验email是否唯一
	 * @param email
	 * @return
	 */
	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public SysUser checkEmailUnique(@PathParam("email") String email) {

		SysUser sysUser = sysUserMapper.checkEmailUnique(email);
		return sysUser;
	}

	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int insertUser(SysUser user) {

		int n = sysUserMapper.insertUser(user);
		return n;
	}
}
