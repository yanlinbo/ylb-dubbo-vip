package com.tuling.service.impl;

import com.tuling.domain.User;
import com.tuling.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//@Service
@DubboService
@Path("/user")
@Produces
public class UserServiceImpl implements UserService {

	@GET
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("uid") String uid) {
		User user = new User();
		user.setUid(uid);
		user.setUsername("yanlinbo");
		return user;
	}
	
}
