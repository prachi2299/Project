package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;

public interface IApplicantRepository  extends CrudRepository<Applicant,String>{

	List<Applicant> findByStatus(AdmissionStatus status);

	Applicant findByapplicantId(String applicantId);


}
