package com.spring.auto;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Italian implements FoodMenu{

	@Override
	public List<String> showItems() {
		return Arrays.asList("Pasta","Pizza","garlic bread");
	}

}
