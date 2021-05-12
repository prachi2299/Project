package com.cg.mts.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exception.AdmissionNotGrantedException;

@ControllerAdvice
public class AdmissionNotGrantedAdvice {

	@ExceptionHandler(value=AdmissionNotGrantedException.class)
	public ResponseEntity<Object> exceptionHandlerMethod(AdmissionNotGrantedException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
}