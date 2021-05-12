package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Admission;
import com.cg.mts.exception.AdmissionNotGrantedException;


public interface IAdmissionService {
	public Admission addAdmission(Admission admission);
	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException;
	public void cancelAdmission(int admissionId) throws AdmissionNotGrantedException;
	
	public List<Admission> showAllAdmissionsByDate(LocalDate admissionDate);
	public List<Admission> showAllAdmissionsByCourseId(int courseId) ;

	
}
