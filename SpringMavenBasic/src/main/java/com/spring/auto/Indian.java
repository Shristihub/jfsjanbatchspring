package com.spring.auto;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Indian implements FoodMenu{

	@Override
	public List<String> showItems() {
		return Arrays.asList("Roti","Dosa","Rice");
	}

}
