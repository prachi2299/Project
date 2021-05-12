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

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.service.IAdmissionService;
@SpringBootTest
class AdmissionTests {

	@Autowired
	private IAdmissionService service;

	@MockBean
	private IAdmissionRepository repo;
	
	@Test
	public void testAddAdmission()
	{
	Admission admission = new Admission(201, 112, "1", LocalDate.parse("2021-05-20"),AdmissionStatus.Applied);
	Mockito.when(repo.save(admission)).thenReturn(admission);

	assertEquals(admission,service.addAdmission(admission));

	}

	@Test
	public void testUpdateAdmission() throws AdmissionNotGrantedException {
		Admission admission = new Admission();
		admission.setAdmissionId(201);
		Mockito.when(repo.save(admission)).thenReturn(admission);
		Mockito.when(repo.existsById(102)).thenReturn(true);
		Admission updatedAdmission = service.updateAdmission(admission);
	
		assertEquals(admission.getAdmissionId(),updatedAdmission.getAdmissionId());

	}
	@Test
	public void testRemoveAdmission() throws AdmissionNotGrantedException {
		Admission admission = new Admission(201, 112, "1", LocalDate.parse("2021-05-20"),AdmissionStatus.Applied);
		service.cancelAdmission(201);
		verify(repo,times(1)).deleteById(201);
	}

	@Test
	public void TestShowAllAdmissionsByDate() {
		 Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
					"1000");
		 Course course1 = new Course(2, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
					"1000");
		 Applicant app=new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied);

		 Mockito.when(repo.findAllByadmissionDate(LocalDate.parse("2021-05-20"))).thenReturn(Stream.of
				(new Admission(201, 1, "101", LocalDate.parse("2021-05-20"),AdmissionStatus.Applied),
						new Admission(202, 2, "101", LocalDate.parse("2021-05-20"),AdmissionStatus.Applied)).collect(Collectors.toList()));
    	 assertEquals(2,service.showAllAdmissionsByDate(LocalDate.parse("2021-05-20")).size());

	}
	@Test
	public void showAllAdmissionsByCourseId() {
		Course course = new Course(1, "Java", "2", LocalDate.parse("2022-11-10"), LocalDate.parse("2022-11-10"),
				"1000");
		
		 Applicant app=new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied);
		 Applicant app1=new Applicant("102","abc","8896753420","12th",78,AdmissionStatus.Applied);
		
		 Mockito.when(repo.findAllBycourseId(1)).thenReturn(Stream.of(new Admission(201, 1, "101", LocalDate.parse("2021-05-20"),AdmissionStatus.Applied),
							new Admission(202, 1, "102", LocalDate.parse("2021-05-21"),AdmissionStatus.Applied)).collect(Collectors.toList()));
		 assertEquals(2,service.showAllAdmissionsByCourseId(1).size());

	}

}
