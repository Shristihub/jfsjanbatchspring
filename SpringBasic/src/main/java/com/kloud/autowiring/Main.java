package com.kloud.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.autowiring");

		// for sutowiring
		ShapeFactory factory = context.getBean("shapeFactory", ShapeFactory.class);
		factory.printArea(10, 20);
//		NewShapeFactory newShapeFactory= context.getBean("newShapeFactory", NewShapeFactory.class);
//        newShapeFactory.printAreaOf("t",30,20);

//		
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//		
//		context.close();
	}

}
