package com.restaurantapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(generator = "rest_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "rest_gen", sequenceName = "rest_sequence",  initialValue = 101, allocationSize = 2)
	private Integer restaurantId;
	
	@Column(length=30)
	private String restaurantName;
	@Column(length=10)
	private String type; // veg or non veg
	@Column(length=30)
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	//rest id will be added to items table
	@JoinColumn(name = "restaurant_id")  // to avoid the junction table
	Set<Item> items;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String restaurantName, String type, String city, Set<Item> items) {
		super();
		this.restaurantName = restaurantName;
		this.type = type;
		this.city = city;
		this.items = items;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", type=" + type
				+ ", city=" + city + ", items=" + items + "]";
	}

	
	
	

}
