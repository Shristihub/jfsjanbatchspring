package com.kloud.autojavabased;

import org.springframework.stereotype.Component;

public class NewRectangle implements NewShape{

	@Override
	public void area(int length, int breadth) {
		System.out.println("Rect "+(length*breadth));
	}

}
