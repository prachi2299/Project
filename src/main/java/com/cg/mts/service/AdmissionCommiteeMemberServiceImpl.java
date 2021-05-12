package com.cg.mts.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;
import com.cg.mts.repository.IApplicantRepository;


@Service
public class AdmissionCommiteeMemberServiceImpl implements IAdmissionCommiteeMemberService  {

	@Autowired
	IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepository ;
	@Autowired
	private IApplicantRepository applicantrepository;
	public void setAdmissionCommiteeMemberRepository(IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepository)
	{
	this.admissionCommiteeMemberRepository = admissionCommiteeMemberRepository;
	}
	
	@Override
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member)
	{
	return admissionCommiteeMemberRepository.save(member);

	}
	
	@Override
	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member){
		return admissionCommiteeMemberRepository.save(member);
	}
	
	@Override
	public void removeCommiteeMember(int adminId)
	{
		admissionCommiteeMemberRepository.deleteById(adminId);
	} 
	
	@Override
	public AdmissionCommiteeMember viewCommiteeMember(int adminId)
	{
	   return admissionCommiteeMemberRepository.findByadminId(adminId);
	}
	
	@Override
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
	return (List<AdmissionCommiteeMember>) admissionCommiteeMemberRepository.findAll();
	}

	@Override
	public void provideAdmissionResult(Applicant applicant, Admission admission) {
		// TODO Auto-generated method stub
	if(applicant.getApplicantGraduationPercent()==0) {
		applicant.setStatus(AdmissionStatus.Pending);
		applicantrepository.save(applicant);

	}
	else {
		switch((admission.getCourseId()%3)+1) {
		case 1:if(applicant.getApplicantGraduationPercent()>70)
			     {applicant.setStatus(AdmissionStatus.Confirmed);
			    admission.setStatus(AdmissionStatus.Confirmed);
			     }
				else {
			         applicant.setStatus(AdmissionStatus.Rejected);
				     admission.setStatus(AdmissionStatus.Rejected);
}
		applicantrepository.save(applicant);

		break;
		case 2:if(applicant.getApplicantGraduationPercent()>65) 
		        {
			        applicant.setStatus(AdmissionStatus.Confirmed);
				    admission.setStatus(AdmissionStatus.Confirmed);
				}
				else {
				     applicant.setStatus(AdmissionStatus.Rejected);
				     admission.setStatus(AdmissionStatus.Rejected);
                     }
		        applicantrepository.save(applicant);

				break;
		case 3:if(applicant.getApplicantGraduationPercent()>60) 
		         {
	               applicant.setStatus(AdmissionStatus.Confirmed);
	      	       admission.setStatus(AdmissionStatus.Confirmed);
		         }
				else {
				     applicant.setStatus(AdmissionStatus.Rejected);
				     admission.setStatus(AdmissionStatus.Rejected);
				}
		        applicantrepository.save(applicant);

				break;
		}
	}

	}
}
