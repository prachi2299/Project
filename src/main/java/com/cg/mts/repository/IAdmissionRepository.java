package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.mts.entities.Admission;


public interface IAdmissionRepository  extends CrudRepository<Admission,Integer>{

	List<Admission> findAllByadmissionDate(LocalDate admissionDate);

    List<Admission> findAllBycourseId(int courseId);

	Admission findByadmissionId(int admissionId);
}
