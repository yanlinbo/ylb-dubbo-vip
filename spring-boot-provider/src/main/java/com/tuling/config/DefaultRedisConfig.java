package com.tuling.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class DefaultRedisConfig {

    @Value("${spring.redis.user.database}")
    private int userDB;
    @Value("${spring.redis.basic.database}")
    private int basicDB;
    @Value("${spring.redis.auction.database}")
    private int auctionDB;
    @Value("${spring.redis.default.database}")
    private int defaultDB;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
//    @Value("${spring.redis.password}")
//    private String pwd;

    public JedisConnectionFactory defaultRedisConnectionFactory(int db){
        return getJedisConnectionFactory(db, host, port, "");
    }

    private JedisConnectionFactory getJedisConnectionFactory(int dbIndex, String host, int port, String pwd) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(dbIndex);
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        /**
         * 为什么要RedisPassword.of(pwd)？
         */
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(pwd));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    public RedisTemplate defaultRedisTemplate(int db){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer(Object.class));
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer(Object.class));
        redisTemplate.setConnectionFactory(defaultRedisConnectionFactory(db));
        return redisTemplate;
    }

    @Bean(name = "userRedisTemplate")
    public RedisTemplate userRedis() {
        return defaultRedisTemplate(userDB);
    }

    @Bean(name = "basicRedisTemplate")
    public RedisTemplate basicRedis() {
        return defaultRedisTemplate(basicDB);
    }

    @Bean(name = "auctionRedisTemplate")
    public RedisTemplate auctionRedis() {
        return defaultRedisTemplate(auctionDB);
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate redis() {
        return defaultRedisTemplate(defaultDB);
    }
}
