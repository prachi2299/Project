package com.cg.mts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
import com.cg.mts.service.AdmissionCommiteeMemberServiceImpl;

@RestController
public class AdmissionCommiteeMemberController {

	@Autowired
	private AdmissionCommiteeMemberServiceImpl admissioncommiteememberservice;
	
	@RequestMapping(method=RequestMethod.POST, value="/admissioncommiteemember")
	public ResponseEntity<Object> addCommiteeMember(@RequestBody AdmissionCommiteeMember member) {
		admissioncommiteememberservice.addCommiteeMember(member);
		return new ResponseEntity<Object>("Course added successfully",HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admissioncommiteemember/{adminId}")
	public void updateCommiteeMember(@RequestBody AdmissionCommiteeMember member,@PathVariable Integer adminId){
		admissioncommiteememberservice.updateCommiteeMember(member);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admissioncommiteemember/{adminId}")
	public void removeCommiteeMember(@PathVariable Integer adminId ) {
		admissioncommiteememberservice.removeCommiteeMember(adminId);
	}
	@RequestMapping("/admissioncommiteemember/{adminId}")
	public AdmissionCommiteeMember viewCommiteeMember(int adminId)
	{
		return admissioncommiteememberservice.viewCommiteeMember(adminId);
	}
	@RequestMapping("/admissioncommiteemember")
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		
		return admissioncommiteememberservice.viewAllCommiteeMembers();
	
	}
	@RequestMapping("/admissioncommiteemember/{admidId}")
	public ResponseEntity<AdmissionCommiteeMember> viewCommiteeMember(@PathVariable Integer adminId){
		AdmissionCommiteeMember member=admissioncommiteememberservice.viewCommiteeMember(adminId);
		return new ResponseEntity<AdmissionCommiteeMember>(member,HttpStatus.FOUND);
	}
	
	@GetMapping("/admissioncommiteemember/result")
	public void provideAdmissionResult
	(@RequestParam("applicantId") Applicant applicant,@RequestParam("admissionId")Admission admission) {
		admissioncommiteememberservice.provideAdmissionResult(applicant, admission);
	}

}
