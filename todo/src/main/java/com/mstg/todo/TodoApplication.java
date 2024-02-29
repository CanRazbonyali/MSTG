package com.mstg.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
@Configuration

public class TodoApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		System.out.println("App started...");
	}
}
