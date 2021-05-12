package com.cg.mts.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.service.AdmissionServiceImpl;

@RestController
public class AdmissionController {

		@Autowired
		private AdmissionServiceImpl admissionservice;
		
		@RequestMapping("/admissions/course/{courseId}")
		public List<Admission> showAllAdmissionsByCourseId(@PathVariable int courseId)
		{
		    return admissionservice.showAllAdmissionsByCourseId(courseId);
		}
		
	    @GetMapping("/admissions/date")
		public List<Admission> showAllAdmissionsByDate
		(@RequestParam("admissionDate")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate admissionDate)
		{
		     return admissionservice.showAllAdmissionsByDate(admissionDate);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/admissions")
		public ResponseEntity<Object> addAdmission(@RequestBody Admission admission)
		{
		admissionservice.addAdmission(admission);
		return new ResponseEntity<Object>("Admission added successfully",HttpStatus.ACCEPTED);

		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/admissions/{admissionId}")
		public ResponseEntity<Object> updateAdmission(@RequestBody Admission admission,@PathVariable int admissionId) throws AdmissionNotGrantedException
		{	
			Admission a = admissionservice.showAllAdmissionByAdmissionId(admissionId);
		
			if(a==null)
				throw new AdmissionNotGrantedException("No admission found for for AdmissionID:"+ admissionId);
			else {
				admissionservice.updateAdmission(admission);
				return new ResponseEntity<Object>("Admission updated successfully",HttpStatus.ACCEPTED);
				}
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/admissions/{admissionId}")
		public ResponseEntity<Object> deleteApplicant(@PathVariable int admissionId)  throws AdmissionNotGrantedException
		{
			
			Admission a = admissionservice.showAllAdmissionByAdmissionId(admissionId);
			if(a==null)
				throw new AdmissionNotGrantedException("No admission found for for AdmissionID:"+ admissionId);
			else {
			admissionservice.cancelAdmission(admissionId);
			return new ResponseEntity<Object>("Admission delete successfully",HttpStatus.ACCEPTED);

			}
		}



}















































/*



@RestController
public class AdmissionController {

	@Autowired
	public AdmissionServiceImpl admissionservice;
	
	@RequestMapping(method=RequestMethod.POST, value="/admission")
	public void addAdmission(@RequestBody Admission admission) {
		admissionservice.addAdmission(admission);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admission/{admissionId}")
	public void updateAdmission(@RequestBody Admission admission,@PathVariable int admissionId){
		admissionservice.updateAdmission(admission);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/admission/{admissionId}")
	public void cancelAdmission(@PathVariable int admissionId) {
		admissionservice.cancelAdmission(admissionId);
	}
	
	@RequestMapping("/admission/{admissionId}")
	public List<Admission> showAllAdmissionsByCourseId(@PathVariable int courseId){
		return (List<Admission>) admissionservice.showAllAdmissionsByCourseId(courseId);
		
	}
	
	@RequestMapping("/admission/{admissionDate}")
	public List<Admission> showAllAdmissionsByDate(@PathVariable LocalDate admissionDate){
		return (List<Admission>) admissionservice.showAllAdmissionsByDate(admissionDate);
		
	}
	
}
*/