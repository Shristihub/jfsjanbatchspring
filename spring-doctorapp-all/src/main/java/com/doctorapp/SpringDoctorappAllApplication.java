package com.doctorapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Address;
import com.doctorapp.model.Casesheet;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Hospital;
import com.doctorapp.model.Speciality;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.IHospitalService;
import com.doctorapp.service.ISpecialityService;

@SpringBootApplication
public class SpringDoctorappAllApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappAllApplication.class, args);
	}

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IHospitalService hospitalService;
	
	@Autowired
	private ISpecialityService specialityService;
	@Override
	public void run(String... args) throws Exception {
	
//		Address address = new Address("RajajiNagar","Bangalore","Karnataka");
//		
//		Speciality speciality = new Speciality(Specialistaion.PHYSICIAN.getSpeciality());
//		Speciality nspeciality = new Speciality(Specialistaion.INTERNAL.getSpeciality());
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(speciality,nspeciality));
//				
//		Hospital hospital = new Hospital("Malar Hospital","Bangalore");
//		Casesheet fcasesheet = new Casesheet("fever and cough");
//		Casesheet scasesheet = new Casesheet("vomiting and cold");
//		Set<Casesheet> casesheets = new HashSet<>(Arrays.asList(fcasesheet,scasesheet));
//		
//		Doctor doctor = new Doctor("Sreedhar", "shree@gmail.com", 600,12,address);
//		doctor.setHospital(hospital);
//		doctor.setCasesheet(casesheets);
//		doctor.setSpeciality(specialities);
//		doctorService.addDoctor(doctor);
		
//		Hospital hospital = new Hospital("Reva Hospital","Hyderabad");
//		hospitalService.addHospital(hospital);
//		Speciality speciality = new Speciality(Specialistaion.DERMA.getSpeciality());
//		specialityService.addSpeciality(speciality);
//		Speciality nspeciality = new Speciality(Specialistaion.DENTIST.getSpeciality());
//		specialityService.addSpeciality(nspeciality);
//		Speciality dspeciality = new Speciality(Specialistaion.COSDENTIST.getSpeciality());
//		specialityService.addSpeciality(dspeciality);
		
//		Address address = new Address("JubileeHills","Hyderabad","Telangana");
//		Doctor doctor = new Doctor("Pavan", "pavan@gmail.com", 1600,10,address);
//		
//		Hospital hospital = hospitalService.getById(101);
//		System.out.println(hospital);
////		hospital.setDoctors(new HashSet<>(Arrays.asList(doctor)));
//		Speciality nspeciality = specialityService.getById(72);
//		Speciality dspeciality = specialityService.getById(73);
//		
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(nspeciality,dspeciality));
//		
//		Casesheet fcasesheet = new Casesheet("tooth ache");
//		Casesheet scasesheet = new Casesheet("root canal surgery");
//		Set<Casesheet> casesheets = new HashSet<>(Arrays.asList(fcasesheet,scasesheet));
//		
//		doctor.setCasesheet(casesheets);
//		doctor.setSpeciality(specialities);
//		doctor.setHospital(hospital);
//		doctorService.addDoctor(doctor);
		doctorService.getAll().forEach(System.out::println);
		
	}

}
