package com.lightprint.webprint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.lightprint.webprint.mapper")
@SpringBootApplication
public class WebprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebprintApplication.class, args);
	}
}
