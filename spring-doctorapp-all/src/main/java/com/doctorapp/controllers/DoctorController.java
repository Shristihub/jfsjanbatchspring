package com.doctorapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("doctor-api")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;
	@PostMapping("/doctors")
	ResponseEntity<Void> addDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/doctors")
	ResponseEntity<List<Doctor>> getAll(){
		List<Doctor> doctors = doctorService.getAll();
		return ResponseEntity.ok().body(doctors);
	}
	
//	List<Doctor> getByCity(String city);
//	List<Doctor> getBySpecialityAndCity(String speciality, String city);
//	List<Doctor> getBySpeciality(String speciality);
//	List<Doctor> getBySpecialityAndExp(String speciality, int experience);
//	List<Doctor> getBySpecialityAndfees(String speciality,double fees);
//	List<Doctor> getBySpecialityAndHospital(String speciality,String hospitalName);
//	List<Doctor> getByHospital(String hospitalName);
//	Doctor getByCaseSheet(Casesheet casesheet);
}
