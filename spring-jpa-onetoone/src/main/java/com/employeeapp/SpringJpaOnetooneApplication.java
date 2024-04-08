package com.employeeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.Address;
import com.employeeapp.model.Employee;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringJpaOnetooneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetooneApplication.class, args);
	}

	@Autowired
	private IEmployeeService employeeService;
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeName("Rose");
		employee.setDepartment("Admin");
		employee.setSalary(12000);
		Address address = new Address("Bangalore","Kar");
		employee.setAddress(address);
		employeeService.addEmployee(employee);
		
		employeeService.getEmpByCity("bangalore").forEach(System.out::println);
		System.out.println("By city and department");
		employeeService.getEmpByCityAndDep("bangalore", "Admin").forEach(System.out::println);
		
		System.out.println("By city and department");
		employeeService.getEmpByCity("Bangalore").forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
