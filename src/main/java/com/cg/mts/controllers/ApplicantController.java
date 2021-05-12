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

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.exception.ApplicantNotFoundException;
import com.cg.mts.service.ApplicantServiceImpl;
@RestController
public class ApplicantController {

	@Autowired
	public ApplicantServiceImpl applicantservice;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/applicants")
	public ResponseEntity<Object> addApplicant(@RequestBody Applicant applicant) {
		applicantservice.addApplicant(applicant);
		return new ResponseEntity<Object>("Applicant added successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/applicants/{applicantId}")
	public ResponseEntity<Object> updateApplicant(@RequestBody Applicant applicant,@PathVariable String applicantId)throws ApplicantNotFoundException {
		
		
		Applicant a = applicantservice.viewApplicant(applicantId);
		if(a==null)
			throw new ApplicantNotFoundException("No applicant found with ApplicantId:"+applicantId);
			
		else {
			applicantservice.updateApplicant(applicant);
			return new ResponseEntity<Object>("Applicant updated successfully",HttpStatus.ACCEPTED);

		}
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/applicants/{applicantId}")
	public ResponseEntity<Object> deleteApplicant(@PathVariable String applicantId) throws ApplicantNotFoundException {
		
		Applicant a = applicantservice.viewApplicant(applicantId);
		if(a==null)
			throw new ApplicantNotFoundException("No applicant found with ApplicantId:"+applicantId);

		else {
			applicantservice.deleteApplicant(applicantId);
			return new ResponseEntity<Object>("Applicant deleted successfully",HttpStatus.ACCEPTED);

		}
	}

	@RequestMapping("/applicants/{applicantId}")
	public ResponseEntity<Applicant> viewApplicant(@PathVariable String applicantId)throws ApplicantNotFoundException{
		Applicant a = applicantservice.viewApplicant(applicantId);
		if(a!=null)
			return new ResponseEntity<Applicant>(a,HttpStatus.OK);
		else
			throw new ApplicantNotFoundException("No applicant found with ApplicantId:"+applicantId);
	}
	
	@RequestMapping("/applicants/status/{status}")
	public List<Applicant> viewAllApplicantsByStatus(@PathVariable AdmissionStatus status) {
	return (List<Applicant>)applicantservice.viewAllApplicantsByStatus(status);
}
	

}
