package com.employeeapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.model.Course;
import com.employeeapp.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

	private ICourseRepository courseRepository;
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public Course getById(int courseId) {
		Optional<Course> courseOpt = courseRepository.findById(courseId);
		if(courseOpt.isPresent())
			return courseOpt.get();
		return null;
	}

}
