package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	// autowiring by type
	@Autowired
	@Qualifier("rectangle")
	private Shape shape; // shape = new Rectangle

	// autowiring by name
	@Autowired
	private Shape square;

	// autowiring by constructor
	private Shape triangle;
	public ShapeFactory(Shape triangle) {
		super();
		this.triangle = triangle;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void printArea(String choice, int x, int y) {
		System.out.println("Printing Area ");
		if (choice.equals("r"))
			shape.area(x, y);
		if (choice.equals("s"))
			square.area(x, y);
		if (choice.equals("t"))
			triangle.area(x, y);
	}


}
