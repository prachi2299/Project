package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;

public interface ICourseService {
	public Course addCourse(Course course);
	public void removeCourse(int courseid) throws CourseNotFoundException;
	public Course updateCourse(Course course) throws CourseNotFoundException;
	public Course viewCourse(int courseid) throws CourseNotFoundException;
	public List<Course> viewAllCourses();
		
}
