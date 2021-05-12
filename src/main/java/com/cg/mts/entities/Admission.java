package com.cg.mts.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="admission")

public class Admission {
	@Id
	@Column(name="admissionId",length=3)
	private int admissionId;
	@Column(name = "courseId",length=3)
	private int courseId;
	@Column(name="applicantId",length=3)
	  private String applicantId;
	 
    
	@Column(name="admissionDate",length=10)
	private LocalDate admissionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private AdmissionStatus status;
	
	public Admission() {}

	public Admission(int admissionId, int courseId, String applicantId, LocalDate admissionDate,
			AdmissionStatus status) {
		super();
		this.admissionId = admissionId;
		this.courseId = courseId;
		this.applicantId = applicantId;
		this.admissionDate = admissionDate;
		this.status = status;
	}


	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}



	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public AdmissionStatus getStatus() {
		return status;
	}

	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}
	
	
}