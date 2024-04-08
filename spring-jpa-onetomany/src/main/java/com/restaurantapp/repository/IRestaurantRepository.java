package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

	List<Restaurant> findByCity(String city);
	List<Restaurant> findByType(String type);
	
	
	@Query("from Restaurant r inner join r.items i where i.cuisine=?1")
	List<Restaurant> findByCuisine(String cuisine);
	
	@Query("from Restaurant r inner join r.items i where i.itemName=?1")
	List<Restaurant> findByItemName(String itemName);
}
