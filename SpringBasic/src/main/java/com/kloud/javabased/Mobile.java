package com.kloud.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Mobile {

	private String brand;
	private String model;
	private Features features;
	public String getBrand() {
		return brand;
	}
	@Value("Samsung")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	@Value("S10")
	public void setModel(String model) {
		this.model = model;
	}
	public Features getFeatures() {
		return features;
	}
//	@Autowired
	public void setFeatures(Features features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", model=" + model + ", features=" + features + "]";
	}
	
	
}
