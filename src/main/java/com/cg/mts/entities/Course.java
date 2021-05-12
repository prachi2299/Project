package com.cg.mts.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

	@Entity
	@Table(name="course")

	public class Course {
	    @Id
	    @Column(name="courseId",length=3)
	private int courseId;
	    @Column(name="courseName",length=15)
	private String courseName;
	    @Column(name="courseDuration",length=15)
	private String courseDuration;
	    @Column(name="courseStartDate",length=10)
	private LocalDate courseStartDate;
	    @Column(name="courseEndDate",length=10)
	private LocalDate courseEndDate;
	    @Column(name="courseFees",length=7)
	private String courseFees;
	   
	
	  @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	  @JoinColumn(name="courseId")
	  private List<Admission> admissions=new ArrayList<>();
	 

	public Course() {};

	
	public Course(int courseId, String courseName, String courseDuration, LocalDate courseStartDate,
			LocalDate courseEndDate, String courseFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseFees = courseFees;
		
	}


	public int getCourseId() {
	return courseId;
	}
	public void setCourseId(int courseId) {
	this.courseId = courseId;
	}
	public String getCourseName() {
	return courseName;
	}
	public void setCourseName(String courseName) {
	this.courseName = courseName;
	}
	public String getCourseDuration() {
	return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
	this.courseDuration = courseDuration;
	}
	public LocalDate getCourseStartDate() {
	return courseStartDate;
	}
	public void setCourseStartDate(LocalDate courseStartDate) {
	this.courseStartDate = courseStartDate;
	}
	public LocalDate getCourseEndDate() {
	return courseEndDate;
	}
	public void setCourseEndDate(LocalDate courseEndDate) {
	this.courseEndDate = courseEndDate;
	}
	
	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	public String getCourseFees() {
	return courseFees;
	}
	public void setCourseFees(String courseFees) {
	this.courseFees = courseFees;
	}
	
}
