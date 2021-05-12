package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exception.ApplicantNotFoundException;
import com.cg.mts.repository.IApplicantRepository;
import com.cg.mts.service.IApplicantService;
@SpringBootTest
class ApplicantTests {

	@Autowired
	private IApplicantService service;

	@MockBean
	private IApplicantRepository repo;
	@Test
	public void testAddApplicant() {

	Applicant app=new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied);
	Mockito.when(repo.save(app)).thenReturn(app);
	assertEquals(app,service.addApplicant(app));

	}
	@Test
	public void testUpdateApplicant() throws ApplicantNotFoundException {
		Applicant app=new Applicant();
		app.setApplicantId("101");
	Mockito.when(repo.save(app)).thenReturn(app);
	Mockito.when(repo.existsById("101")).thenReturn(true);
	Applicant updatedApplicant = service.updateApplicant(app);

	assertEquals(app.getApplicantId(),updatedApplicant.getApplicantId());


	}
	
	@Test
	public void testDeleteApplicant() throws ApplicantNotFoundException{
		Applicant app=new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied);

	service.deleteApplicant("101");
	verify(repo,times(1)).deleteById("101");
	}
	@Test
	public void TestViewApplicant() throws ApplicantNotFoundException{

		
		Mockito.when(repo.findByapplicantId("101")).
				thenReturn(new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied));
		assertEquals("101",service.viewApplicant("101").getApplicantId());
	}
    @Test
	public void TestViewAllApplicantsByStatus() {
    	Mockito.when(repo.findByStatus(AdmissionStatus.Applied)).
    	thenReturn(Stream.of
    			(new Applicant("101","abc","9896753420","12th",78,AdmissionStatus.Applied),	
    			new Applicant("102","abc","9896752320","12th",60,AdmissionStatus.Applied),
    			new Applicant("103","abc","9890052320","12th",60,AdmissionStatus.Applied)).collect(Collectors.toList()));
    	assertEquals(3,service.viewAllApplicantsByStatus(AdmissionStatus.Applied).size());

    }

	

}
