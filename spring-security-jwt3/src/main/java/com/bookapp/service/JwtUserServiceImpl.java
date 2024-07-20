package com.bookapp.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.bookapp.model.JwtUser;
import com.bookapp.repository.IJwtUserRepository;

@Service
public class JwtUserServiceImpl implements UserDetailsManager {

	@Autowired
	private IJwtUserRepository  jwtUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser user = jwtUserRepository.findByUsername(username);
		System.out.println(user);
		if(user==null)
			throw new UsernameNotFoundException("invalid user");
		String password = user.getPassword();
		List<String> authorities = user.getAuthorities();
		Collection<GrantedAuthority> gauthorities = 
		authorities.stream()
		// convert string into grantedauthority
		.map(authority-> new SimpleGrantedAuthority(authority))
		.collect(Collectors.toList());
		
		UserDetails userDetails = new User(username,password,gauthorities);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public void saveUser(JwtUser jwtuser) {
		System.out.println(jwtuser);
		jwtUserRepository.save(jwtuser);
		
	}
	

}
