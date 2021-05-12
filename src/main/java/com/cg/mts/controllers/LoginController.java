package com.cg.mts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.LoginFailedException;
import com.cg.mts.service.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl loginservice;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/login/commitee")
	public ResponseEntity<Object> loginAsAdmissionCommiteeMember(@RequestBody UniversityStaffMember member)  throws LoginFailedException
	{
		if(loginservice.loginAsAdmissionCommiteeMember(String.valueOf(member.getStaffId()), member.getPassword()))
			return new ResponseEntity<Object>(HttpStatus.FOUND);
		else
			throw new LoginFailedException("Invalid Login Credentials");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login/staff")
	public ResponseEntity<Object> loginAsUniversityStaffMember(@RequestBody UniversityStaffMember member)  throws LoginFailedException
	{
		if(loginservice.loginAsUniversityStaffMember(String.valueOf(member.getStaffId()), member.getPassword()))
			return new ResponseEntity<Object>(HttpStatus.FOUND);
		else
			throw new LoginFailedException("Invalid Login Credentials");
	}
}