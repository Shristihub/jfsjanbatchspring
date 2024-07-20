package com.kloud.constr;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudMain {

	public static void main(String[] args) {
		// this is the IOC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.constr");
		// show the beans created by the IOC container
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		Student student  = (Student)context.getBean("student");
		System.out.println(student);
		
	}
}
