package com.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.model.Employee;
import com.employeeapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	
	IEmployeeRepository employeeRepository;
	@Autowired
	public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	@Override
	public void deleteEmployee(int employeeId) {
			employeeRepository.deleteById(employeeId);
	}
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee getById(int employeeId) {
		Optional<Employee> empopt =  employeeRepository.findById(employeeId);
		if(empopt.isPresent())
			return empopt.get();
		return null;
	}
	@Override
	public List<Employee> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> getByCategoryMode(String category, String mode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
