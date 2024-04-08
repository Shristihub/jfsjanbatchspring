package com.spring.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Customer {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.auto");
		Waiter waiter = context.getBean("waiter",Waiter.class);
		waiter.showMenuCard("in").forEach(System.out::println);
	}
}
