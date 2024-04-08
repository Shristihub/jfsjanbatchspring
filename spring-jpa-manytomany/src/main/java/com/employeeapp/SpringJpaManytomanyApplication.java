package com.employeeapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.Course;
import com.employeeapp.model.Employee;
import com.employeeapp.service.ICourseService;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringJpaManytomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManytomanyApplication.class, args);
	}
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private ICourseService courseService;
	@Override
	public void run(String... args) throws Exception {
		
//		Course acourse = new Course("Java","fullstack", "offline");
//		Course bcourse = new Course("Angular","fullstack", "offline");
//		Course dcourse = new Course("JUnit","testing", "online");
//		
//		Set<Course> courses = new HashSet<>(Arrays.asList(acourse,bcourse,dcourse));
//		
//		Employee employee = new Employee("Sri","Bangalore","Mktg");
//		employee.setCourses(courses);
//		employeeService.addEmployee(employee);
		
		
		Employee employee = new Employee("Rahul","Bangalore","Tech");
		// add a set of courses that are already available.
		// get the course by Id
		Course xcourse = courseService.getById(1);
		Course ycourse = courseService.getById(2);
		// create a set of courses
		Set<Course> courses = new HashSet<>(Arrays.asList(xcourse,ycourse));
		// add the courses to the employee object
		employee.setCourses(courses);
		
		// call addEmployee method
		employeeService.addEmployee(employee);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
