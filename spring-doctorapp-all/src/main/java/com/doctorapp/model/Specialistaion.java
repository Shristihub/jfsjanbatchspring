package com.doctorapp.model;

public enum Specialistaion {
	PHYSICIAN("General Physician"),
	INTERNAL("Internal Medicine"),
	COSDENTIST("Cosmetic dentist"),
	DENTIST("Dentist"),
	NEURO("Neurologist"),
	DERMA("Dermatologist");

	private String specialityName;

	private Specialistaion(String specialityName) {
		this.specialityName = specialityName;
	}
	
	public String getSpeciality() {
		return specialityName;
	}
	

}
