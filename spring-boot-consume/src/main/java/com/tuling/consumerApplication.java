package com.tuling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class consumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(consumerApplication.class);
	}
}
