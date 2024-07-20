package com.bookapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bookapp.service.JwtUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Bean
	public UserDetailsManager userDetailsService() {
		return new JwtUserServiceImpl();
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
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(authenticationEntryPoint))
				.authorizeHttpRequests(auth -> auth
						// authorize users with role as user or admin
						.requestMatchers("/book-api/v1/books/**").hasAnyAuthority("USER", "ADMIN")
						// authorize users with role as admin
						.requestMatchers("/book-api/v1/books/admin/**").hasAuthority("ADMIN")
						// authorize users with role as user or admin
						.requestMatchers("/user-api/v1/register", "/user-api/v1/authenticate").permitAll().anyRequest()
						.authenticated());
				http.authenticationProvider(authenticationProvider());
				http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				return http.build();
	}
}
