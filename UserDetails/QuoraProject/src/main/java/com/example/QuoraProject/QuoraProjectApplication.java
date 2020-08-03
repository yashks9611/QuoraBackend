package com.example.QuoraProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class QuoraProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoraProjectApplication.class, args);
	}

}
