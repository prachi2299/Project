package com.cg.mts.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import javax.persistence.Table;
@Entity
@Table(name="applicant")
public class Applicant {
	@Id
	@Column(name="applicantId",length=3,unique=true)
	private String applicantId;
	
	@Column(name="applicantName",length=20)
	private String applicantName;
	
	@Column(name="mobNo",unique=true)
	@Size(min=10,max=10)
	private String mobileNumber;
	
	@Column(name="applicantDegree",length=15)
	private String applicantDegree;
	
	@Column(name="applicantPer",length=3)
	@Min(0)
	@Max(100)
	private int applicantGraduationPercent;
	
	 @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	 @JoinColumn(name="applicantId")
	 private List<Admission> admissions=new ArrayList<>();
	 
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private AdmissionStatus status;


	public Applicant() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Applicant(String applicantId, String applicantName, String mobileNumber, String applicantDegree,
			int applicantGraduationPercent,  AdmissionStatus status) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this.mobileNumber = mobileNumber;
		this.applicantDegree = applicantDegree;
		this.applicantGraduationPercent = applicantGraduationPercent;
		this.status = status;
	}

	
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getApplicantDegree() {
		return applicantDegree;
	}
	public void setApplicantDegree(String applicantDegree) {
		this.applicantDegree = applicantDegree;
	}
	public int getApplicantGraduationPercent() {
		return applicantGraduationPercent;
	}
	public void setApplicantGraduationPercent(int applicantGraduationPercent) {
		this.applicantGraduationPercent = applicantGraduationPercent;
	}

	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	public AdmissionStatus getStatus() {
		return status;
	}
	public void setStatus(AdmissionStatus status) {
		this.status = status;
	}

}
