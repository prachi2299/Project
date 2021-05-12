package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.service.ICourseService;

@SpringBootTest
class CourseTests {
	
	@Autowired
	private ICourseService service;

	@MockBean
	private ICourseRepository repo;

	@Test
	public void testAddCourse() {
		
     Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000");
	Mockito.when(repo.save(course)).thenReturn(course);

	assertEquals(course,service.addCourse(course));


	}
	@Test
	public void testUpdateCourse() throws CourseNotFoundException {
	Course course = new Course();
	course.setCourseId(12);
	Mockito.when(repo.save(course)).thenReturn(course);
	Mockito.when(repo.existsById(12)).thenReturn(true);
	Course updatedCourse = service.updateCourse(course);

	assertEquals(course.getCourseId(),updatedCourse.getCourseId());


	}
	@Test
	public void testRemoveCourse() throws CourseNotFoundException {
	Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000");
	service.removeCourse(1);
	verify(repo,times(1)).deleteById(1);
	}
	
	@Test
	public void testViewCourse() throws CourseNotFoundException {
	Mockito.when(repo.findBycourseId(1))
	.thenReturn(new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000"));
	assertEquals(1,service.viewCourse(1).getCourseId());
	}

	@Test
	public void testViewAllCourses() {
	Mockito.when(repo.findAll())
	.thenReturn(Stream.of(new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000"),new Course(2, "Java 2.0", "3", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000")).collect(Collectors.toList()));
	assertEquals(2,service.viewAllCourses().size());
	}
	

}
