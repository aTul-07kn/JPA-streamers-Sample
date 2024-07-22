package com.example.Employee_jpastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.example.Employee_jpastreamer", "com.speedment.jpastreamer"} )
public class EmployeeJpastreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeJpastreamerApplication.class, args);
	}

}
