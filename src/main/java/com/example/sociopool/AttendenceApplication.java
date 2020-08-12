package com.example.sociopool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class AttendenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendenceApplication.class, args);
		System.out.println(" Attendence Management Application Started...");
	}

}
