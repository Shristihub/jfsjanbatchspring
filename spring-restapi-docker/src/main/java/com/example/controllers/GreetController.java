package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//	http://localhost:8080/greet
	// this is the rest endpoint
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to spring";
	}

//	http://localhost:8080/show-courses
	@GetMapping("/show-courses")
	public List<String> showCourses() {
		return Arrays.asList("java", "spring", "angular");
	}

//	http://localhost:8080/say-hello/priya
	// data comes in the url
	@GetMapping("/say-hello/{username}")
	public String welcomeUser(@PathVariable("username") String uname) {
		return "Hello " + uname;
	}

}
