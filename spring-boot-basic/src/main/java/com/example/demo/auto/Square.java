package com.example.demo.auto;

import org.springframework.stereotype.Component;

@Component
public class Square  implements Shape {

	@Override
	public void area(int x, int y) {
		System.out.println("Sq "+(x*x));
	}

}
