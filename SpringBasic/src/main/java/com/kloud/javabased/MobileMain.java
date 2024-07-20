package com.kloud.javabased;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MobileMain {

	public static void main(String[] args) {
		// this is the IOC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.javabased");
		// show the beans created by the IOC container
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		Mobile mobile = context.getBean("getMobile", Mobile.class);
		System.out.println(mobile);
		
		((AbstractApplicationContext)context).close();
		
	}
}
