package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Doctor;


public interface IDoctorService {

	void addDoctor(Doctor doctor); 	
	void updateDoctor(Doctor doctor);
	Doctor getById(int doctorId); 
	void deleteDoctor(int doctorId);
	List<Doctor> getAll();
	
	List<Doctor> getByCity(String city);
	List<Doctor> getBySpecialityAndCity(String speciality, String city);
	List<Doctor> getBySpeciality(String speciality);
	List<Doctor> getBySpecialityAndExp(String speciality, int experience);
	List<Doctor> getBySpecialityAndfees(String speciality,double fees);
	List<Doctor> getBySpecialityAndHospital(String speciality,String hospitalName);
	List<Doctor> getByHospital(String hospitalName);
	Doctor getByCaseSheet(Casesheet casesheet);
	
}
