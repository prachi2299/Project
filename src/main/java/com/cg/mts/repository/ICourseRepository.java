package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;

public interface ICourseRepository  extends CrudRepository<Course,Integer>{

	Course findBycourseId(int courseid);
	/*public void addCourse(Course course);
	public void removeCourse(int courseid) throws CourseNotFoundException;
	public void updateCourse(Course course) throws CourseNotFoundException;
	public Optional<Course> viewCourse(int courseid) throws CourseNotFoundException;
	public List<Course> viewCourseList();
	*/
	
}
