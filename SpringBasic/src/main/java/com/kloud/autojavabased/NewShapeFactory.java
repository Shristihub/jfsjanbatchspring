package com.kloud.autojavabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class NewShapeFactory {
	@Autowired
	private NewShape newShape; 
	public void printArea(int x, int y) {

		System.out.println("printing area");
		newShape.area(x, y);
	}

}
