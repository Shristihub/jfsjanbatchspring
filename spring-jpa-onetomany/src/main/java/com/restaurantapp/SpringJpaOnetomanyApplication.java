package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringJpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyApplication.class, args);
	}
	@Autowired
	private IRestaurantService restaurantService;
	

	@Override
	public void run(String... args) throws Exception {
		Item itemOne= new Item("vada","Starters", "SI", 100);
		Item itemTwo= new Item("Idly","breakfast", "SI", 200);
		Item itemThree= new Item("Fried Rice","Main", "Chinese", 200);
//		
		List<Item> itemsList = Arrays.asList(itemOne,itemTwo,itemThree);
		Set<Item> items = new HashSet<>(Arrays.asList(itemOne,itemTwo,itemThree));
		Restaurant restaurant = new Restaurant("Upupi", "veg", "Bangalore", items);
		restaurantService.addRestaurant(restaurant);
		
		restaurantService.getByCity("Bangalore").forEach(System.out::println);
		
		restaurantService.getByItemName("Fried Rice").forEach((rest)->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCity());
			System.out.println(rest.getType());
		});
		System.out.println();
		restaurantService.getByCuisine("Chinese").forEach((rest)->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCity());
			System.out.println();
			Set<Item> itemss = rest.getItems();
			itemss.forEach((item)->{
				System.out.println(item.getItemName()+" "+item.getPrice()+" "+item.getCategory());
			});
			
		});
		
		
	}

}
