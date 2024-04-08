package com.employeeapp.model;

public class Employee {

	private String employeeName;
	private String city;
	private double salary;
	private Integer employeeId;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", city=" + city + ", salary=" + salary + ", employeeId="
				+ employeeId + "]";
	}
	
}
