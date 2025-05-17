package com.example.twilio_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class TwilioDemoApplication {
	public static void main(String[] args){

		SpringApplication.run(TwilioDemoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("admin123"));


	}}
