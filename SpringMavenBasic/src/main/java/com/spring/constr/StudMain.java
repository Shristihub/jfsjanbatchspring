package com.spring.constr;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class StudMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.spring.constr");
		Student student = (Student)context.getBean("student"); // new Student()
		System.out.println(student);
		
		Student student1 = context.getBean("student",Student.class);
		System.out.println(student1);
		
		Student student2 = context.getBean(Student.class);
		System.out.println(student2.getStudentName());
		
		// to get all beans from the IocContainer
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.stream(beanNames).forEach(bean->System.out.println(bean));
		
		
		context.close();
		
		
	}
}
