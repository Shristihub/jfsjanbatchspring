package com.doctorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{

}
