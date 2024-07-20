package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class GreetController {

	@GetMapping("/")
	public String show() {
		return "Great day";
	}
	@GetMapping("/admin/add")
	public String addBook() {
		return "Book added";
	}
	@GetMapping("/admin/update")
	public String updateBook() {
		return "Book updated";
	}
	@GetMapping("/user/show")
	public List<String> showBooks() {
		return Arrays.asList("Java","Spring","React");
	}
	@GetMapping("/user/one")
	public String getOne() {
		return "Spring";
	}
}
