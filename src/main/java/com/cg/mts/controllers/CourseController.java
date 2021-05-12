package com.cg.mts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.service.CourseServiceImpl;


@RestController
public class CourseController {

	@Autowired
	private CourseServiceImpl courseservice;
	
	@RequestMapping("/courses")
	public List<Course> viewAllCourses()
	{
	   return courseservice.viewAllCourses();
	}
	
	@RequestMapping("/courses/{courseId}")
	public ResponseEntity<Course> viewCourse(@PathVariable Integer courseId) throws CourseNotFoundException
	{
	
		Course c = courseservice.viewCourse(courseId);
		if(c==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);

		else
		return new ResponseEntity<Course>(c,HttpStatus.OK);

		}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public ResponseEntity<Object> addCourse(@RequestBody Course course)
	{
	   courseservice.addCourse(course);
		return new ResponseEntity<Object>("Course added successfully",HttpStatus.ACCEPTED);

	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}")
	public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable Integer courseId) throws CourseNotFoundException
	{
		Course c=courseservice.viewCourse(courseId);
		if(c==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseId);
		else {
		 courseservice.updateCourse(course);

			return new ResponseEntity<Object>("Course updated successfully",HttpStatus.ACCEPTED);

		
	}
	
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseid}")
	public ResponseEntity<Object> removeCourse(@PathVariable Integer courseid) throws CourseNotFoundException
	{ 
	
		Course c=courseservice.viewCourse(courseid);
		if(c==null)
			throw new CourseNotFoundException("No course found with CourseID:"+ courseid);
		else {
		courseservice.removeCourse(courseid);
		return new ResponseEntity<Object>("Course deleted successfully",HttpStatus.ACCEPTED);
		}
	}
	
}
/*@RestController
@RequestMapping("/courses")

public class CourseController {
@Autowired
private CourseServiceImpl courseservice;

@GetMapping(value="/all",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Course>> viewAllCourses()
{
return new ResponseEntity<List<Course>>(courseservice.viewAllCourses(),HttpStatus.OK);
}


@GetMapping(value="/{courseid}",produces="application/json")
public ResponseEntity<Optional<Course>>viewCourse(@PathVariable("courseid")int courseid)
{
Optional<Course> c=courseservice.viewCourse(courseid);

if(c.isPresent())
 return new ResponseEntity<Optional<Course>>(c,HttpStatus.OK);
return new ResponseEntity<Optional<Course>>(c,HttpStatus.NO_CONTENT);


}

@DeleteMapping(value="{courseid}")
public ResponseEntity<HttpStatus> removeCourse(@PathVariable("courseid") int courseid) {
courseservice.removeCourse(courseid);
return new ResponseEntity<HttpStatus>(HttpStatus.OK);

}

@PostMapping(consumes="application/json")
public ResponseEntity<HttpStatus> addCourse(@RequestBody Course course) {
courseservice.addCourse(course);
return new ResponseEntity<HttpStatus>(HttpStatus.OK);

}
@PutMapping(consumes="application/json")
public ResponseEntity<HttpStatus> updateCourse(@RequestBody Course course) {
courseservice.updateCourse(course);
return new ResponseEntity<HttpStatus>(HttpStatus.OK);

}
}*/
