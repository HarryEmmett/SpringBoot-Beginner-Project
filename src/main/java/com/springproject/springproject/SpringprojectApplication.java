package com.springproject.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.quiet-period=1000", "true");
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
