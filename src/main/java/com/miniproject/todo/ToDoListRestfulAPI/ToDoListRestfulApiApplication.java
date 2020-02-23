package com.miniproject.todo.ToDoListRestfulAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.miniproject.todo"})
public class ToDoListRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListRestfulApiApplication.class, args);
	}

}
