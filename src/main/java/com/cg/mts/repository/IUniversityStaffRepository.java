package com.cg.mts.repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.UniversityStaffMember;

public interface IUniversityStaffRepository  extends CrudRepository<UniversityStaffMember,Integer>{

	public UniversityStaffMember findBystaffId(int staffid);
	
	/*public  UniversityStaffMember addStaff(UniversityStaffMember user);
public UniversityStaffMember updateStaff(UniversityStaffMember user);
public UniversityStaffMember viewStaff(int staffid);
public void removeStaff(int staffid);
public List<UniversityStaffMember> viewAllStaffs();*/
}
