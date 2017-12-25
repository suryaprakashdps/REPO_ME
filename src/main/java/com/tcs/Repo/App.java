package com.tcs.Repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
//		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(App.class);
		SpringApplication.run(App.class, args);
		System.out.println("Application started");
	}
}
