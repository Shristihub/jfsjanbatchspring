package com.bookapp.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebConfig extends  WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private JwtRequestFilter jwtRequestFilter;
	
	/**
	 * @param jwtAuthenticationEntryPoint the jwtAuthenticationEntryPoint to set
	 */
	@Autowired
	public void setJwtAuthenticationEntryPoint(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}

	/**
	 * @param jwtRequestFilter the jwtRequestFilter to set
	 */
	@Autowired
	public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
		this.jwtRequestFilter = jwtRequestFilter;
	}

	/**
	 * @param userDetailsService the userDetailsService to set
	 */
	@Autowired
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors().and()
		.authorizeRequests()
		// donot authenticate these urls
		.antMatchers("/user-api/register","/user-api/authenticate").permitAll()
		// authenticate any other requests
		.anyRequest().authenticated()
		.and()
		// use Jwtauthenticationentry point to send errors
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		// session is stateless here - do not handle session
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// move to the filter in the flow
		 // the reqestfilter will be called before usernamepasswordfilter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
}
