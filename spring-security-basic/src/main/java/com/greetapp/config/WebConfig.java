package com.greetapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {

	//inmemory authentication
	// two beans
	// authentication bean
	@Bean
	public UserDetailsManager  userDetails() {
		UserDetails user = User.withUsername("Priya")
							.password(encodePassword().encode("priya123"))
							.roles("USER")
							.build();
		UserDetails user1 = User.withUsername("Sri")
				.password(encodePassword().encode("sri123"))
				.roles("ADMIN","USER")
				.build();
		return new InMemoryUserDetailsManager(user1,user);
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	// authorization bean
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		// authorize http requests based on roles
//		//implement Customizer functional interface
	 http
		  .csrf(csrf->csrf.disable())
		  .authorizeHttpRequests(httpRequests->{
			httpRequests
			.requestMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
			.requestMatchers("/api/admin/**").hasAnyRole("ADMIN")
			.requestMatchers("/").permitAll()
			.anyRequest()
			.authenticated();
		})
		.sessionManagement(session->{
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		})
		.httpBasic(Customizer.withDefaults());

		return http.build();

	}

	
	
}
