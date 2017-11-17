package com.fx.la;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fx.la.mapper")
public class LaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaApplication.class, args);
	}
}
