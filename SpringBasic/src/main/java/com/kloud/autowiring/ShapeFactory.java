package com.kloud.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	
	@Autowired
	@Qualifier("rectangle") // autowiring by type
	// similar to shape = new Rectangle()
	Shape nshape;

	@Autowired
	// bean name and instance variable name are same
	// autowiring by name
	Shape square;

	Shape triangle; // by constructor
	
	public ShapeFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public ShapeFactory(@Qualifier("triangle")Shape triangle) {
		super();
		this.triangle = triangle;
	}

	public void printArea(int x, int y) {

		System.out.println("printing area");
		nshape.area(100, 200);
		triangle.area(x, y);
		square.area(x, y);
	}

}
