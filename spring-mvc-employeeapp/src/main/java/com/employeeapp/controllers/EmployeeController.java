package com.employeeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeeapp.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping("show-form")
	public String show() {
		return "showform";
	}
	
//	@RequestMapping("/addEmployee")
//	public String addEmpl(
//			@RequestParam("emplName") String empName,
//			@RequestParam("employeeId") int empId,
//			@RequestParam("city") String city,
//			@RequestParam("salary") double salary,
//			ModelMap map
//			) {
//		Employee employee = new Employee();
//		employee.setCity(city);
//		employee.setEmployeeId(empId);
//		employee.setEmployeeName(empName);
//		employee.setSalary(salary);
//		
//		map.addAttribute("employee", employee);
//		return "success";
//	}

   // if instance variable names and form field names are same
	// no need to use requestparam annotation
	@RequestMapping("/addEmployee")
	public String addEmpl(Employee employee,ModelMap map) {
		map.addAttribute("employee", employee);
		return "success";
	}
}
