package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Java61Application {

	public static void main(String[] args) {
		SpringApplication.run(Java61Application.class, args);
	}
	@GetMapping("/hello")
	public String hello() {
		return String.format("Hello World");
	}
	@GetMapping("/goodbye")
	public String goodbye() {
		return String.format("good bye World");
	}
	@GetMapping("/alphabet")
	public String alphabet() {
		return "ABCDEFG";
	}
	@GetMapping("/calc")
	public String calcA() {
		return String.valueOf(1+3);
	}
}
