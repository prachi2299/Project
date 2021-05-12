package com.cg.mts.service;

public interface ILoginService {

	public boolean loginAsAdmissionCommiteeMember(String username,String pwd);
	public boolean loginAsUniversityStaffMember(String username,String pwd);
	
}
