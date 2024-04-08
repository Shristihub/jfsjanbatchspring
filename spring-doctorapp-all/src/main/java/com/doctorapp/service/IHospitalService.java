package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Hospital;



public interface IHospitalService {

	void addHospital(Hospital hospital); 	
	void updateHospital(Hospital hospital);
	Hospital getById(int hospitalId); 
	void deleteHospital(int hospitalId);
	List<Hospital> getAll();
	
	List<Hospital> getByCity(String city);
	List<Hospital> getBySpecialityAndCity(String speciality, String city);
	List<Hospital> getBySpeciality(String speciality);
	List<Hospital> getBySpecialityAndExp(String speciality, int experience);
	List<Hospital> getByDoctor(String doctorName);
	List<Hospital> getBySpecialityAndDoctor(String speciality,String doctor);
	List<Hospital> getByHospital(String hospitalName);
	
	
}
