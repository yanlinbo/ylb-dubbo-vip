package com.tuling.service;

import com.tuling.domain.User;
import com.tuling.domain.entity.SysUser;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
@Consumes
public interface UserService {
    @GET
    @Path("/{uid}")
    public User getUser(@PathParam("uid") String uid);

    @GET
    @Path("/{userId}")
    public SysUser getSysUser(@PathParam("userId") Long userId);
}
