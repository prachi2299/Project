package com.cg.mts.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	ICourseRepository courserepository;
	public void setICourseRepository(ICourseRepository courserepository)
	{
	this.courserepository = courserepository;
	}
	@Override
	@Transactional
	public Course addCourse(Course course) {
	 return courserepository.save(course);
	}
	@Override
	@Transactional
	public void removeCourse(int courseid) throws CourseNotFoundException {
		
		
		 courserepository.deleteById(courseid);
	
	}
	@Override
	@Transactional
	public Course updateCourse(Course course) throws CourseNotFoundException  {
	 return courserepository.save(course);
	}
	@Override
	public Course viewCourse(int courseid) throws CourseNotFoundException{

		return courserepository.findBycourseId(courseid);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> viewAllCourses() {
	return (List<Course>) courserepository.findAll();
	}
	
	
	//public Optional<Course> getCourse(int courseId){
		//return courserepository.findById(courseId);
	//}
}
