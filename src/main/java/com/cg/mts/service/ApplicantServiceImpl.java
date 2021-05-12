package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.repository.IApplicantRepository;
@Service
public class ApplicantServiceImpl implements IApplicantService{


	@Autowired
	private IApplicantRepository applicantrepository;
	
	public void setIApplicantRepository(IApplicantRepository applicantrepository) {
		this.applicantrepository=applicantrepository;
	}
	@Override
	public Applicant addApplicant(Applicant applicant) {
		
	 return applicantrepository.save(applicant);
	
	}
	
	@Override
	public Applicant updateApplicant(Applicant applicant) {
	return applicantrepository.save(applicant);
	
	}
	
	@Override
	public void deleteApplicant(String applicantId) {
	    applicantrepository.deleteById(applicantId);
	
	}
	
	@Override
	public Applicant viewApplicant(String applicantId) {
	return applicantrepository.findByapplicantId(applicantId);
	}
	
	@Override
	public List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status) {
	return (List<Applicant>) applicantrepository.findByStatus(status);
	
	}
	
	  public List<Applicant> viewAllApplicants() {
	  
	  return (List<Applicant>)applicantrepository.findAll();
	  
	  }
	 
}