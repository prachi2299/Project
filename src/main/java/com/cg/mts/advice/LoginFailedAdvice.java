package com.cg.mts.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.mts.exception.LoginFailedException;

@ControllerAdvice
public class LoginFailedAdvice {
	@ExceptionHandler(value=LoginFailedException.class)
	public ResponseEntity<Object> exceptionHandlerMethod(LoginFailedException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
}
