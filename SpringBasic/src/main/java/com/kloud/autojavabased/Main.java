package com.kloud.autojavabased;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.autojavabased");
	
		// for sutowiring
		NewShapeFactory factory  = context.getBean("getFactory",NewShapeFactory.class);
		factory.printArea(10,20);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		context.close();
	}

}
