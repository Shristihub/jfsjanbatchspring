package com.example.demo.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	// by type
	@Autowired
	@Qualifier("square") //shape = new Rectangle()
	Shape shape;

//	by name
//	the bean name and the instance variable name should be same
	@Autowired
	Shape triangle;
	
	
	Shape rectangle;
	public ShapeFactory(Shape rectangle) {
		super();
		this.rectangle = rectangle;
	}


	public void printArea(int x, int y) {
	 System.out.println("Printing area");
	 shape.area(x, y);
	 triangle.area(x, y);
	 rectangle.area(x, y);
	
	}

}
