package com.spring.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring");
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
	}

}
