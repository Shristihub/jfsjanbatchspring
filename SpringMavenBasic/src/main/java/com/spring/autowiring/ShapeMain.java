package com.spring.autowiring;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ShapeMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");
		ShapeFactory factory = context.getBean("shapeFactory", ShapeFactory.class);

		// to get all beans from the IocContainer
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(bean -> System.out.println(bean));

//		factory.printArea(10, 20);
		factory.printArea("s", 10, 20);
		factory.printArea("r", 10, 20);
		factory.printArea("t", 10, 20);
		
	}
}
