package com.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctorapp.model.Hospital;
import com.doctorapp.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService{
	
		private IHospitalRepository iHospitalRepository;

		public HospitalServiceImpl(IHospitalRepository iHospitalRepository) {
			super();
			this.iHospitalRepository = iHospitalRepository;
		}

		@Override
		public void addHospital(Hospital hospital) {
			iHospitalRepository.save(hospital);
		}

		@Override
		public void updateHospital(Hospital hospital) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Hospital getById(int hospitalId) {
			return iHospitalRepository.findById(hospitalId).get();
		}

		@Override
		public void deleteHospital(int hospitalId) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Hospital> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getByCity(String city) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getBySpecialityAndCity(String speciality, String city) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getBySpeciality(String speciality) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getBySpecialityAndExp(String speciality, int experience) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getByDoctor(String doctorName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getBySpecialityAndDoctor(String speciality, String doctor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Hospital> getByHospital(String hospitalName) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
