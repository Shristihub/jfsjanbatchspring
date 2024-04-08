package com.trial.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //IocContainer will create an object 
public class Employee {

	private String employeeName;
	private double salary;
	private Address address;
	
	public String getEmployeeName() {
		return employeeName;
	}
	@Value("Jo")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public double getSalary() {
		return salary;
	}
	@Value("2000.0")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	@Autowired  // inject address objetc into emp object using setter based DI
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", salary=" + salary + ", address=" + address + "]";
	}
	
}
