package com.bookapp.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.bookapp.model.ApiUser;
import com.bookapp.repository.IApiUserRepository;

@Service
public class ApiUserServiceImpl implements UserDetailsManager{

	@Autowired
	private IApiUserRepository apiUserRepository;
	
	// call the method loadUser of ApiUserServiceImpl
	// to check username and password is available
			// if not 401 unauthorized
			// if not authorized 403 unauthorized
			
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		ApiUser apiUser = apiUserRepository.findByUsername(username);
		System.out.println(apiUser);
		if(apiUser==null)
			throw new UsernameNotFoundException("username doesnot exist");
		// get the properties from ApiUser and populate UserDetails
		String uname = apiUser.getUsername();
		String password = apiUser.getPassword();
//		Set<Role> roles = apiUser.getRoles();
//		System.out.println(roles);
//		
//		Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		roles.stream().forEach(role->{
//			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.getRoleName());
//			grantedAuthorities.add(auth);
//		});
////			 .map(role->{
////				 new SimpleGrantedAuthority(role.getRoleName());
////			 })
////			 .collect(Collectors.toList());
//		        
//		System.out.println(grantedAuthorities);
		// create roles using SimpleGrantedAuthority hard coded
	    SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority("USER");
		SimpleGrantedAuthority auth2 = new SimpleGrantedAuthority("ADMIN");
		// Add the SimpleGrantedAuthority ies to a collection
		Collection<GrantedAuthority> grantedAuthorities = 
				                   Arrays.asList(auth2);
//				
//		Pass the collection as parameter to userdetails
//		USerDetails is an interface USer  in an inbuilt class implemeting it
		UserDetails userDetails =  new User(uname,password,grantedAuthorities);
		System.out.println(userDetails);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		
		
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
	
	public void addUser(ApiUser apiUser) {
		apiUserRepository.save(apiUser);
		
	}

}
