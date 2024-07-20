package com.kloud.autojavabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ShapeConfig {

	@Bean
	public NewSquare getSq() {
		return new NewSquare();
	} 
	@Bean
	public NewTriangle getTri() {
		return new NewTriangle();
	} 
	
	@Bean
	@Primary // the bean that qualifies for autowiring
	public NewRectangle getRect() {
		return new NewRectangle();
	} 
	
	@Bean
	public NewShapeFactory getFactory() {
		return new NewShapeFactory();
	} 
	
}
