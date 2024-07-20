package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.ApiUser;
import com.bookapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {
	
	@Autowired
	public ApiUserServiceImpl apiUserService;
	@Autowired
	public PasswordEncoder passwordEncoder;

	@PostMapping("/apiusers/register")
	public ResponseEntity<String> register(@RequestBody ApiUser apiUser) {
		String password= apiUser.getPassword();
		String npass = passwordEncoder.encode(password);
		apiUser.setPassword(npass);
		apiUserService.addUser(apiUser);
		return ResponseEntity.ok("user added");		
	}
	
	
		
	
}
