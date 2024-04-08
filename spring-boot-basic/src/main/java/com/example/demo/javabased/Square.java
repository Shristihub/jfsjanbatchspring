package com.example.demo.javabased;

public class Square  implements Shape {

	@Override
	public void area(int x, int y) {
		System.out.println("Sq "+(x*x));
	}

}
