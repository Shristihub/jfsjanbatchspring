package com.kloud.autojavabased;

import org.springframework.stereotype.Component;

public class NewSquare implements NewShape{

	@Override
	public void area(int length, int breadth) {
		System.out.println("Sq "+(length*length));
	}

}
