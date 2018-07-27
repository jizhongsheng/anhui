package com.dtdream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.dtdream")
@ComponentScan(basePackages = "com.dtdream")
@SpringBootApplication
public class PowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerApplication.class, args);
	}
}
