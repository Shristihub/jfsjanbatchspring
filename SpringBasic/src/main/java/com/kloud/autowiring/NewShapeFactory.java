package com.kloud.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class NewShapeFactory {
    @Autowired
    @Qualifier("square")
    Shape shape;
    
    @Autowired
    Shape triangle;
    
    Shape rectangle;
    public NewShapeFactory(Shape rectangle) {
    	super();
        this.rectangle = rectangle;
    }
    public void printAreaOf(String choice,int length, int breadth) {

            System.out.println("Area of rectangle");
            rectangle.area(length,breadth);
            System.out.println("Area of triangle");
            triangle.area(length,breadth);
            System.out.println("Area of square");
            shape.area(length,breadth);
    }
}
 