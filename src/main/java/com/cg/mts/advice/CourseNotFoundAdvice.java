package com.cg.mts.advice;
//package com.cg.mts.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exception.CourseNotFoundException;

@ControllerAdvice
public class CourseNotFoundAdvice {
	
	

	@ExceptionHandler(value=CourseNotFoundException.class)
	public ResponseEntity<Object> exceptionHandlerMethod(CourseNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}

