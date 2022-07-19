package com.tuling.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    /**
     * 原始的注入类，可以对任何库进行操作
     */
//    @Resource
//    private RedisTemplate<String, String> redisTemplate;

    /**
     * 自定义指定库的操作类
     */
    @Resource(name = "auctionRedisTemplate")
    private RedisTemplate<String, String> auctionRedisTemplate;
    @Resource(name = "userRedisTemplate")
    private RedisTemplate<String, String> userRedisTemplate;
    @Resource(name = "basicRedisTemplate")
    private RedisTemplate<String, String> basicRedisTemplate;
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    public Object getValue(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }


    public void setValue(String key, String value) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key, 1, TimeUnit.HOURS); // 这里指的是1小时后失效
    }

}
