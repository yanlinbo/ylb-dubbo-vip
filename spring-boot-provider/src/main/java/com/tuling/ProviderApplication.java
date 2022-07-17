package com.tuling;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 注意别把包路径写错了，否则消费者找不到依赖了
 */
@EnableDubbo(scanBasePackages = "com.tuling.service")
@MapperScan("com.tuling.mapper")
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class);
	}
}
