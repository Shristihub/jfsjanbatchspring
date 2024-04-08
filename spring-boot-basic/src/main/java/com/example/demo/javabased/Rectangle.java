package com.example.demo.javabased;

public class Rectangle  implements Shape {

	@Override
	public void area(int x, int y) {
		System.out.println("Rect "+(x*y));
	}

}
