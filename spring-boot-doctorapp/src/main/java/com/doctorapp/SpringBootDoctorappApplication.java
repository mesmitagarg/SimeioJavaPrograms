package com.doctorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootDoctorappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDoctorappApplication.class, args);
	}

}
