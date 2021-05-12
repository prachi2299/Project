package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.repository.IApplicantRepository;

@Service
public class AdmissionServiceImpl implements IAdmissionService{

	
	@Autowired
	private IAdmissionRepository admissionRepository;
	@Autowired
	private IApplicantRepository applicantrepository;
	public void setAdmissionrepository(IAdmissionRepository admissionRepository) {
		this.admissionRepository = admissionRepository;
	}
	
	@Override
	public Admission addAdmission(Admission admission) {
		Applicant applicant=applicantrepository.findByapplicantId(admission.getApplicantId());
		applicant.setStatus(AdmissionStatus.Applied);
		   return admissionRepository.save(admission);
	}
	
	@Override
	public void cancelAdmission(int admissionId)
	{
	    admissionRepository.deleteById(admissionId);
	}
	
	@Override
	public Admission updateAdmission(Admission admission) {
	  return admissionRepository.save(admission);
	}
	@Override
	public List<Admission> showAllAdmissionsByDate(LocalDate admissionDate)
		{
			return (List<Admission>) admissionRepository.findAllByadmissionDate(admissionDate);
		}

	@Override
	public List<Admission> showAllAdmissionsByCourseId(int courseId) {
	
	return (List<Admission>) admissionRepository.findAllBycourseId(courseId);
	}

	public Admission showAllAdmissionByAdmissionId(int admissionId) {
		return  admissionRepository.findByadmissionId(admissionId);
	}
	

}

