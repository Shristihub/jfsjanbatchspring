package com.example.demo.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class ShapeDetails {
	
	@Autowired
	@Qualifier("getTri")
	Shape shape;
	
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}


	public void printArea(int x, int y) {
	 System.out.println();
	 System.out.println("Printing area of shape details");
	 shape.area(x, y);
	
	
	}

}
