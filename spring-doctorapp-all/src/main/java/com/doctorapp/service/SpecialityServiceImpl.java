package com.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctorapp.model.Speciality;
import com.doctorapp.repository.ISpecialityRepository;

@Service
public class SpecialityServiceImpl implements ISpecialityService {
	private ISpecialityRepository iSpecialityRepository;

	public SpecialityServiceImpl(ISpecialityRepository iSpecialityRepository) {
		super();
		this.iSpecialityRepository = iSpecialityRepository;
	}

	@Override
	public void addSpeciality(Speciality speciality) {
		iSpecialityRepository.save(speciality);
		
	}

	@Override
	public void updateSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Speciality getById(int specialityId) {
		return iSpecialityRepository.findById(specialityId).get();
	}

	@Override
	public void deleteSpeciality(int specialityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Speciality> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Speciality> getByDoctor(String doctorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Speciality> getByHospitalAndDoctor(String hospital, String doctor) {
		// TODO Auto-generated method stub
		return null;
	}

}
