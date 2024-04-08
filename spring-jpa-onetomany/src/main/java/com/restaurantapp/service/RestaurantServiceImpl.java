package com.restaurantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Restaurant;
import com.restaurantapp.repository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService{
	
	private IRestaurantRepository restaurantRepository;
	
	@Autowired
	public void setRestaurantRepository(IRestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
		
	}

	@Override
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant getById(int restaurantId) {
		Optional<Restaurant> restOpt =  restaurantRepository.findById(restaurantId);
		if(restOpt.isPresent())
			return restOpt.get();
		return null;
	}

	@Override
	public List<Restaurant> getByCity(String city) {
		return restaurantRepository.findByCity(city);
	}

	@Override
	public List<Restaurant> getByType(String type) {
		return restaurantRepository.findByType(type);
	}

	@Override
	public List<Restaurant> getByItemName(String itemName) {
		return restaurantRepository.findByItemName(itemName);
	}

	@Override
	public List<Restaurant> getByCuisine(String cuisine) {
		return restaurantRepository.findByCuisine(cuisine);
	}

	
}
