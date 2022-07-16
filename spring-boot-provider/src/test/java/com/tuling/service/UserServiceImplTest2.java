package com.tuling.service;

import com.tuling.UTContext;
import com.tuling.domain.User;
import com.tuling.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 第二种写法：mock框架(类似于框架阶段编码)
 * 这种方式有两种写法：
 * 1，注解：@RunWith(MockitoJUnitRunner.class)
 * 2，方法：MockitoAnnotations.initMocks(this);
 */
//@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest2 extends UTContext {

    /**
     * @InjectMocks 这个注解是用来注入被测试类的
     * @Mock 这个注解是用来模拟依赖的
     */
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void init() throws Exception{
        //做一些单测前的初始化工作
        MockitoAnnotations.initMocks(this);;
    }

    @Test
    public void getUserTest(){
//        UserService userService = mock(UserService.class);
        //第一步：给一个建设条件
        String uid = "1";
        //第二步：根据假设条件获得实际的结果
        User user = userServiceImpl.getUser(uid);
        //第三步：断言实际的结果与期望的结果是否一致
        Assert.assertEquals("yanlinbo",user.getUsername());
    }

    /**
     * mock使用的一个简单例子
     */
    @Test
    public void mockTest(){
        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

}
