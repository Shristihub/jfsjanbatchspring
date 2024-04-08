package com.spring.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Waiter {

	@Autowired
	@Qualifier("indian")
	private FoodMenu foodMenu;
	
	@Autowired
	private FoodMenu chinese;
	@Autowired
	private FoodMenu italian;
	
	public List<String> showMenuCard(String choice){
		System.out.println("food items in menu");
		if(choice.equals("in"))
			return foodMenu.showItems();
		if(choice.equals("it"))
			return italian.showItems();
		if(choice.equals("ch"))
			return chinese.showItems();
		return null;
	}
}
