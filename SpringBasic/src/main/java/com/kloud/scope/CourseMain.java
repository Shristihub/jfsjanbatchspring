package com.kloud.scope;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseMain {

	public static void main(String[] args) {
		// this is the IOC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kloud.scope");
		Course course = context.getBean("course", Course.class);
		
		System.out.println("1st: "+course);
		System.out.println("1st: "+course.getCourseName());
		
		Course course1 = context.getBean("course", Course.class);
		System.out.println("2nd: "+course1);
		System.out.println("2nd: "+course1.getCourseName());
		
		course1.setCourseName("Java");
		System.out.println("1st: "+course);
		System.out.println("1st: "+course.getCourseName());
		System.out.println("2nd: "+course);
		System.out.println("2nd: "+course1.getCourseName());
		
		
	}
}
