package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Speciality;



public interface ISpecialityService {

	void addSpeciality(Speciality speciality); 	
	void updateSpeciality(Speciality speciality);
	Speciality getById(int specialityId); 
	void deleteSpeciality(int specialityId);
	List<Speciality> getAll();
	
	List<Speciality> getByDoctor(String doctorName);
	List<Speciality> getByHospitalAndDoctor(String hospital,String doctor);
	
	
}
