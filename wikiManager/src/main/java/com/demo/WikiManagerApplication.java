package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo"})
public class WikiManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiManagerApplication.class, args);
	}

}
