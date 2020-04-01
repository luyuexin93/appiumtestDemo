package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = { "com.demo.springboot" })
public class DemoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootApplication.class, args);
	}

}
