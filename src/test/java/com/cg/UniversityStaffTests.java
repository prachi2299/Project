package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.service.IUniversityStaffService;
@SpringBootTest
class UniversityStaffTests {

	@Autowired
	private IUniversityStaffService service;

	@MockBean
	private IUniversityStaffRepository repo;
	@MockBean
	private ICourseRepository courseRepo;

	@Test
	public void testStaff() {
	Mockito.when(repo.findBystaffId(1)).thenReturn(new UniversityStaffMember(1, "laka", "engineer"));

	assertEquals(1, service.viewStaff(1).getStaffId());
	}

	@Test
	public void testViewAllStaffs() {
	Mockito.when(repo.findAll()).thenReturn(Stream.of(new UniversityStaffMember(1, "koko", "doc"),new UniversityStaffMember(2, "bkaa", "analyst")).collect(Collectors.toList()));

	assertEquals(2, service.viewAllStaffs().size());
	}

	@Test
	public void testAddStaff() {
	UniversityStaffMember user = new UniversityStaffMember(1, "laka", "engineer");
	Mockito.when(repo.save(user)).thenReturn(user);

	assertEquals(user, service.addStaff(user));
	}
	@Test
	public void testViewStaff() {
	Mockito.when(repo.findBystaffId(1)).thenReturn(new UniversityStaffMember(1, "laka", "engineer"));

	assertEquals(1, service.viewStaff(1).getStaffId());
	}
	@Test
	public void testUpdateStaff() {
	UniversityStaffMember user = new UniversityStaffMember();
	user.setStaffId(2);
	Mockito.when(repo.save(user)).thenReturn(user);
	Mockito.when(repo.existsById(2)).thenReturn(true);
	UniversityStaffMember updatedStaff = service.updateStaff(user);

	assertEquals(user.getStaffId(), updatedStaff.getStaffId());
	}

	@Test
	public void testRemoveStaff() {
	UniversityStaffMember user = new UniversityStaffMember(1, "laka", "engineer");
	service.removeStaff(1);
	verify(repo, times(1)).deleteById(1);
	}
	

	@Test
	public void testAddCourse() {
	Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000");
	Mockito.when(courseRepo.save(course)).thenReturn(course);
	assertEquals(course, service.addCourse(course));
	}

	@Test
	public void testUpdateCourse() throws CourseNotFoundException {
	Course course = new Course();
	course.setCourseId(12);
	Mockito.when(courseRepo.save(course)).thenReturn(course);
	Mockito.when(courseRepo.existsById(12)).thenReturn(true);
	Course updatedCourse = service.updateCourse(course);

	assertEquals(course.getCourseId(), updatedCourse.getCourseId());

	}

	@Test
	public void testRemoveCourse() throws CourseNotFoundException {
	Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
	"1000");
	service.removeCourse(1);
	verify(courseRepo, times(1)).deleteById(1);
	}
}
