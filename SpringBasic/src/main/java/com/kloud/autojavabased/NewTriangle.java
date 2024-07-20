package com.kloud.autojavabased;

import org.springframework.stereotype.Component;

public class NewTriangle implements NewShape{

	@Override
	public void area(int length, int breadth) {
		System.out.println("Tri "+(breadth*length*0.5));
	}

}
