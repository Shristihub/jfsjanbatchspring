package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.config.JwtTokenUtil;
import com.bookapp.model.JwtUser;
import com.bookapp.service.JwtUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class JwtUserController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUserServiceImpl userServiceImpl;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	// this will be the first url to be called
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody JwtUser jwtuser) {
		String pass = jwtuser.getPassword();
		String password = passwordEncoder.encode(pass);
		jwtuser.setPassword(password);
		userServiceImpl.saveUser(jwtuser);
		return ResponseEntity.ok("user added");
	}

	// this is used to authenticate the user
	// if the user is available, then atoken is generated
	// the response here is the token
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody JwtUser jwtuser) {
		// get the username, password
		String username = jwtuser.getUsername();
		String password = jwtuser.getPassword();
		// call a method authenticate to specify the type of authentication
		authenticate(username,password);
		// call the method to check if the user is available
		UserDetails userdetails =userServiceImpl.loadUserByUsername(jwtuser.getUsername());
		// generate the token
		String token = jwtTokenUtil.generateToken(userdetails);
		// return the token in the response
		return ResponseEntity.ok(token);
	}

	private void authenticate(String username,String password) {
		try {
		// authenticate the username and password using authentication manager
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			System.out.println(e.getMessage());
		}catch(LockedException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
