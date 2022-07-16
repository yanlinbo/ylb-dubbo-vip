package com.tuling.service;

import com.tuling.UTContext;
import com.tuling.domain.User;
import com.tuling.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.PathParam;

/**
 * 第一种写法：原始的junit(类似于编程初期的servlet编码)
 */
public class UserServiceImplTest1 extends UTContext {

    private UserService userServiceImpl;

    /**
     * 第一种：最原始的初始化方式（junit）
     */
    @Before
    public void init(){
        //做一些单测前的初始化工作
         userServiceImpl = new UserServiceImpl();
    }


    /**
     * 场景一：测试正确数据
     */
    @Test
    public void getUserTest(){
        //第一步：给一个建设条件
        String uid = "1";
        //第二步：根据假设条件获得实际的结果
        User user = userServiceImpl.getUser(uid);
        //第三步：断言实际的结果与期望的结果是否一致
        Assert.assertEquals("yanlinbo",user.getUsername());
    }

    /**
     * 场景二：测试错误数据
     */
    @Test
    public void getUserTestError(){
        //第一步：给一个建设条件
        String uid = "1";
        //第二步：根据假设条件获得实际的结果
        User user = userServiceImpl.getUser(uid);
        //第三步：断言实际的结果与期望的结果是否一致
        Assert.assertNotEquals("严林博",user.getUsername());
    }

}
