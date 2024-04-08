package com.example.demo.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // a class with all bean definitions
public class AppConfig {
	
	@Bean
	@Primary
	public Square getSq() {
		return new Square();
	}
	@Bean // a spring bean is created and the bean name is getRect
	public Rectangle getRect() {
		return new Rectangle();
	}
	@Bean
	public Triangle getTri() {
		return new Triangle();
	}

	@Bean   // this or the below one
	public ShapeDetails getDetails() {
		return new ShapeDetails();
	}
	
//	@Bean  
//	public ShapeDetails getShapeDetails() {
//		ShapeDetails details =  new ShapeDetails();
//		details.setShape(getRect());
//		return details;
//	}
	
	
}
