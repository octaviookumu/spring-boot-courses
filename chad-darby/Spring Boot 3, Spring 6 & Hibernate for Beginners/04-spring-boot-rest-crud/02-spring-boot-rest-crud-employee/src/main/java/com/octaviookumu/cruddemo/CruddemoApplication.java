package com.octaviookumu.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Development process
	// 1. Update db configs in application.properties
	// 2. Create Employee entity
	// 3. Create DAO interface
	// 4. Create DAO implementation
	// 5. Create REST controller to use DAO

}
