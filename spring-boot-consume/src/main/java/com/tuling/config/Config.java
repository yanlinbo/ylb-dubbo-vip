package com.tuling.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;

/**
 * 为什么要创建这个配置类？
 * 如果没有在这个配置类中构建RestTemplate作为bean放入容器，则在OrderService中无法取到RestTemplate的对象
 *
 */
@Configuration
public class Config {

//	@Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder){
//        return builder.build();
//    }
}
