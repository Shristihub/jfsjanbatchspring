package com.doctorapp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(generator = "hospital_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hospital_gen",sequenceName = "hospital_seq",initialValue = 50,allocationSize = 1)
	private Integer hospitalId;
	@Column(length=30)
	private String hospitalName;
	private String city;
	@JsonIgnore
	@OneToMany(mappedBy = "hospital",fetch=FetchType.EAGER)
	Set<Doctor> doctors;
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hospital(String hospitalName, String city) {
		super();
		this.hospitalName = hospitalName;
		this.city = city;
	}
	/**
	 * @return the hospitalId
	 */
	public Integer getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * @return the doctors
	 */
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	/**
	 * @param doctors the doctors to set
	 */
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", city=" + city + "]";
	}
	
	
	
}
