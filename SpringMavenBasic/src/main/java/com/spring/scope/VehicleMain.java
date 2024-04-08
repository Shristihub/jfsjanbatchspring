package com.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.constr.Student;

public class VehicleMain {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.spring.scope");

		Vehicle vehicle1 = (Vehicle) context.getBean("vehicle");
		System.out.println("V1 " + vehicle1.getModel());
		
		// need this as a a new object - 
		Vehicle vehicle2 = (Vehicle) context.getBean("vehicle");
		System.out.println("V2 " + vehicle2.getModel());
		
		vehicle1.setModel("Civic");
		System.out.println("V1 " + vehicle1.getModel());
		System.out.println("V2 " + vehicle2.getModel());
	}
}
