package com.employeeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.model.Employee;
import com.employeeapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmpById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public List<Employee> getEmpByCity(String city) {
		return employeeRepository.findByCity(city);
	}

	@Override
	public List<Employee> getEmpByDep(String department) {
		return employeeRepository.findByDepartment(department);
	}

	@Override
	public List<Employee> getEmpByCityAndDep(String city, String department) {
		return employeeRepository.findByCityDep(city, department);
	}



}
