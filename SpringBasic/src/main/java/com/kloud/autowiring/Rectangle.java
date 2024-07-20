package com.kloud.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape{

	@Override
	public void area(int length, int breadth) {
		System.out.println("Rect "+(length*breadth));
	}

}
