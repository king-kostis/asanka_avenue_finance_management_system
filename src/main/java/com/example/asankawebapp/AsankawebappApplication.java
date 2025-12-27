package com.example.asankawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.asankawebapp.model"})
@EnableAutoConfiguration
public class AsankawebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsankawebappApplication.class, args);
	}

}
