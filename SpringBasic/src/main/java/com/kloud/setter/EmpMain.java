package com.kloud.setter;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		// this is the IOC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.setter");
		// show the beans created by the IOC container
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		// get the employee bean
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
		
		Employee employee1 = context.getBean("employee",Employee.class);
		System.out.println(employee1);
		
		Employee employee2 = context.getBean(Employee.class);
		System.out.println(employee2);
		
	}
}
