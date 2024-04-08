package com.example.demo.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String studentName;
	private String department;
	private Course course;
	
	// create a constructor and pass course object as a parameter
	//this is injecting
	public Student(Course course) {
		super();
		this.course = course;
	}
	public String getStudentName() {
		return studentName;
	}
	@Value("${student.studentName}")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	@Value("${student.department}")
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + ", course=" + course + "]";
	}
	
}
