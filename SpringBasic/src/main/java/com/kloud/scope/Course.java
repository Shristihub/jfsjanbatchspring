package com.kloud.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // creates a new bean for evry getBean ca
@PropertySource("classpath:application.yml")
public class Course {

	private String courseName;
	private String type;
	public String getCourseName() {
		return courseName;
	}
	@Value("${course.courseName}")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getType() {
		return type;
	}
	@Value("${course.type}")
	public void setType(String type) {
		this.type = type;
	}
//	@Override
//	public String toString() {
//		return "Course [courseName=" + courseName + ", type=" + type + "]";
//	}
//	
	
}
