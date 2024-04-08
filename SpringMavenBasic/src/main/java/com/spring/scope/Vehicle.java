package com.spring.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // creates a new object
public class Vehicle {

	private String model;
	private String brand;
	private double price;
	public String getModel() {
		return model;
	}
	@Value("City")
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	@Value("Honda")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	@Value("300000")
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
