package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;

import com.cg.mts.service.IAdmissionCommiteeMemberService;
@SpringBootTest
class AdmissionCommiteeMemberTests {

	@Autowired
	private IAdmissionCommiteeMemberService service;

	@MockBean
	private IAdmissionCommiteeMemberRepository repo;
	


	@Test
	public void addCommiteeMember()
	{
		AdmissionCommiteeMember member=new AdmissionCommiteeMember(121,"abc","123456");
		Mockito.when(repo.save(member)).thenReturn(member);
	
		assertEquals(member,service.addCommiteeMember(member));
	}

	@Test
	public void testUpdateAdmissionCommiteeMember()
	{
		AdmissionCommiteeMember member=new AdmissionCommiteeMember();
		member.setAdminId(111);
		Mockito.when(repo.save(member)).thenReturn(member);
		Mockito.when(repo.existsById(111)).thenReturn(true);
		AdmissionCommiteeMember updateCommiteeMember=service.updateCommiteeMember(member);
		assertEquals(member.getAdminId(),updateCommiteeMember.getAdminId());
	}

	@Test
	public void testRemoveCommiteeMember()
	{
		AdmissionCommiteeMember member=new AdmissionCommiteeMember(121,"abc","123456");
		service.removeCommiteeMember(121);
		verify(repo,times(1)).deleteById(121);
	}
	@Test
	public void testViewCommiteeMember() {
		Mockito.when(repo.findByadminId(1)).thenReturn(
		new AdmissionCommiteeMember(1, "admin1", "9900990099"));
		assertEquals(1, service.viewCommiteeMember(1).getAdminId());
	}

	@Test
	public void testViewAllCommiteeMember() {
		Mockito.when(repo.findAll()).thenReturn(Stream.of(
		new AdmissionCommiteeMember(1, "admin1", "9900990099"),
		new AdmissionCommiteeMember(2, "admin2", "9999900000"))
		.collect(Collectors.toList()));
		assertEquals(2, service.viewAllCommiteeMembers().size());
	}
	@Test
	public void testProvideAdmissionResult() {
		Applicant app = new Applicant("101","abc","9874563210","12th",78,AdmissionStatus.Applied);
		Admission admission = new Admission(201,1, "101", LocalDate.parse("2020-02-02"),AdmissionStatus.Applied);
		service.provideAdmissionResult(app, admission);
		assertEquals(AdmissionStatus.Confirmed,app.getStatus());

	}
}
