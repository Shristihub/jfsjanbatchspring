package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.bookapp.service.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	@Bean
	public UserDetailsManager userDetailsService() {
		return new ApiUserServiceImpl();
	}

	@Bean
	public PasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	// provides database specific authentication
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encodePassword());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
		 .csrf(csrf->csrf.disable())
		 .authorizeHttpRequests(auth->
		    auth
		    .requestMatchers("/book-api/v1/books/**").hasAnyAuthority("USER","ADMIN")
		    .requestMatchers("/book-api/v1/books/admin/**").hasRole("ADMIN")
		    .requestMatchers("/user-api/v1/apiusers/register").permitAll()
		    .anyRequest()
			.authenticated()
		    )
		
		.httpBasic(Customizer.withDefaults())
		.authenticationProvider(authenticationProvider())
		.build();
	}
}
