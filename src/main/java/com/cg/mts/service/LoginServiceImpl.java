package com.cg.mts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.IUniversityStaffRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IUniversityStaffRepository universitystaffrepository;
	@Override
	public boolean loginAsAdmissionCommiteeMember(String username, String pwd) {
		UniversityStaffMember user = universitystaffrepository.findBystaffId(Integer.parseInt(username));
		String password = user.getPassword();
		String role = user.getRole();
		if(password.equals(pwd) && role.equals("commitee member"))
			return true;
		else
			return false;
	}

	@Override
	public boolean loginAsUniversityStaffMember(String username, String pwd) {
		UniversityStaffMember user = universitystaffrepository.findBystaffId(Integer.parseInt(username));
		String password = user.getPassword();
		String role = user.getRole();
		if(password.equals(pwd) && role.equals("staff member"))
			return true;
		else
			return false;
	}
}
