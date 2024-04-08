package com.example.demo.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	// by type
	@Autowired
	@Qualifier("rectangle") //shape = new Rectangle()
	Shape shape;

//	by name
//	the bean name and the instance variable name should be same
	@Autowired
	Shape triangle;
	
	@Autowired
	Shape shaper;
	
	public void printArea(int x, int y) {
	 System.out.println("Printing area");
	 shape.area(x, y);
	 triangle.area(x, y);
	 shaper.area(x, y);
	
	}

}
