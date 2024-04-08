package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@RequestMapping("/greet")
	public String greetUser(Model model) {
		// call the service layer
		model.addAttribute("message", "Have a great day");
		return "success";
	}
	

	@RequestMapping("/welcome")
	public String welcomeUser(ModelMap model) {
		// call the service layer
		model.addAttribute("message", "Welcome to MVC");
		return "success";
	}
	
	@RequestMapping("/sayhello")
	public ModelAndView welcomeUser() {
//		create a ModelAndView object and return it
		return new ModelAndView("success","message", "Hello!!!");
	}
}
