package com.kloud.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // has also the bean definitions to create spring bean
public class AppConfig {

	
	//bean defeinitions to create a java object
	// The IOC container creates it
	@Bean
	public Mobile getMobile() {
		Mobile mobile = new Mobile();
		mobile.setFeatures(getFeatures());
		return mobile;
	}
	
	@Bean
	public Features getFeatures() {
		return new Features();
	}
}
