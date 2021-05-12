package com.cg.mts.repository;


import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.AdmissionCommiteeMember;


public interface IAdmissionCommiteeMemberRepository extends CrudRepository<AdmissionCommiteeMember,Integer>{


	AdmissionCommiteeMember findByadminId(int i);

/*public  AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member);
public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member);
public AdmissionCommiteeMember viewCommiteeMember(int adminId);
public void removeCommiteeMember(int adminId);
public List<AdmissionCommiteeMember> viewAllCommiteeMembers();*/
}
