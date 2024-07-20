package com.kloud.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
	private String deptName;
	private String deptHead;
	
	public String getDeptName() {
		return deptName;
	}
	@Value("${student.department.deptName}")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}
	@Value("${student.department.deptHead}")
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
	

}
