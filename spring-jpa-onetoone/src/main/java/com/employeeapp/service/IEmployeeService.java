package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.Employee;

public interface IEmployeeService {

	void addEmployee(Employee employee);
	
	Employee getEmpById(int employeeId);
	List<Employee> getEmpByCity(String city);
	
	List<Employee> getEmpByDep(String department);
	
	List<Employee> getEmpByCityAndDep(String city, String department);
}
