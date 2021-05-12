package com.cg.mts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.service.UniversityStaffServiceImpl;

@RestController
public class UniversityStaffController {

	@Autowired
	UniversityStaffServiceImpl universitystaffservice;
	
	@RequestMapping("/universitystaff")
	public List<UniversityStaffMember> viewAllStaffs(){
		return universitystaffservice.viewAllStaffs();
	}

	@RequestMapping("/universitystaff/{staffid}")
	public ResponseEntity<UniversityStaffMember> viewStaff(@PathVariable int staffid) {
		UniversityStaffMember s= universitystaffservice.viewStaff(staffid);
		return new ResponseEntity<UniversityStaffMember>(s,HttpStatus.OK);

	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/universitystaff/{staffid}")
	public ResponseEntity<Object> removeStaff(@PathVariable int staffid) {
		universitystaffservice.removeStaff(staffid);
		return new ResponseEntity<Object>(" Staff remove successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/universitystaff/{staffid}")
	public ResponseEntity<Object> updateStaff(@RequestBody UniversityStaffMember user,@PathVariable Integer staffid)
	{
		universitystaffservice.updateStaff(user);
		return new ResponseEntity<Object>(" Staff updated successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/universitystaff")
	public ResponseEntity<Object> addStaff(@RequestBody UniversityStaffMember user)
	{
		universitystaffservice.addStaff(user);
		return new ResponseEntity<Object>(" Staff added successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/universitystaff/courses")
	public ResponseEntity<Object> addCourse(@RequestBody Course course)
	{
		universitystaffservice.addCourse(course);
		return new ResponseEntity<Object>("Course added successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/universitystaff/courses/{courseId}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable Integer courseId) throws CourseNotFoundException
	{
		UniversityStaffMember s=universitystaffservice.viewStaff(courseId);
		if(s==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
		else {
		universitystaffservice.updateCourse(course);
		return new ResponseEntity<Object>("Course updated successfully",HttpStatus.ACCEPTED);

		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/universitystaff/courses/{courseId}")
	public ResponseEntity<Object> removeCourse(@PathVariable int courseId) throws CourseNotFoundException
	{
		UniversityStaffMember s=universitystaffservice.viewStaff(courseId);
		if(s==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
		else {
		universitystaffservice.removeCourse(courseId);
		return new ResponseEntity<Object>("Course delete successfully",HttpStatus.ACCEPTED);

		}
	}



		
}
