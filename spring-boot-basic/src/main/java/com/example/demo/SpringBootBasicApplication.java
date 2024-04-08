package com.example.demo;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.auto.ShapeFactory;
import com.example.demo.constr.Student;
import com.example.demo.javabased.ShapeDetails;
import com.trial.basics.Employee;

@SpringBootApplication(scanBasePackages = {"com.example","com.trial"})
//@ComponentScan({"com.example","com.trial"})
public class SpringBootBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}
	@Autowired
	ApplicationContext context;
	@Autowired
	Employee employee;
	
	@Autowired
	Student student;
	
	@Autowired
	ShapeFactory factory;
	
	@Autowired
	ShapeDetails details;
	
	@Override
	public void run(String... args) throws Exception {
//		Employee employee = context.getBean("employee",Employee.class);
		System.out.println(employee);
		System.out.println(student);
		factory.printArea(1, 20);
		details.printArea(20, 10);
		
		System.out.println();
		System.out.println("Beans created by the APP Context");
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		
	}

}
