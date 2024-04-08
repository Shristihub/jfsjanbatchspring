package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle  implements Shape {

	@Override
	public void area(int x, int y) {
		System.out.println("Rect "+(x*y));
	}

}
