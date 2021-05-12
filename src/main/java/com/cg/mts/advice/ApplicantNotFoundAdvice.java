package com.cg.mts.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exception.ApplicantNotFoundException;


@ControllerAdvice
public class ApplicantNotFoundAdvice {
	
	@ExceptionHandler(value=ApplicantNotFoundException.class)
	public ResponseEntity<Object> exceptionHandlerMethod(ApplicantNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
}