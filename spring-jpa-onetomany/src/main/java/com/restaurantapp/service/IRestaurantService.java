package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.model.Restaurant;

public interface IRestaurantService {
	
//	    in built
		Restaurant addRestaurant(Restaurant restaurant);
		void updateRestaurant(Restaurant restaurant);
		void deleteRestaurant(int restaurantId);	
		List<Restaurant> getAll();
		Restaurant getById(int restaurantId);
		
//		derived queries
		List<Restaurant> getByCity(String city);
		List<Restaurant> getByType(String type); // veg or non veg

		
//		 custom queries
		List<Restaurant> getByItemName(String itemName);  // dosa
		List<Restaurant> getByCuisine(String cuisine); 
	}



