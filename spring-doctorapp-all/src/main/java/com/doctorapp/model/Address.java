package com.doctorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_gen",sequenceName = "address_seq",initialValue = 10,allocationSize = 1)
	private Integer addressId;
	@Column(length=30)
	private String location;
	@Column(length=30)
	private String city;
	@Column(length=30)
	private String state;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String location, String city, String state) {
		super();
		this.location = location;
		this.city = city;
		this.state = state;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", location=" + location + ", city=" + city + ", state=" + state
				+ "]";
	}
	
	
	
}
