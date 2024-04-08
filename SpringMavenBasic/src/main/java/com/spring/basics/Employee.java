package com.spring.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String employeeName;
	private Integer employeeId;
	private Address address;
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	@Value("Jo")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	@Value("10")
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public Address getAddress() {
		return address;
	}
	@Autowired // inject address using setter emp.setAddress(address)
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", address=" + address + "]";
	}
	
}
