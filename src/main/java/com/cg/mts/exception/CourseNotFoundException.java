package com.cg.mts.exception;

public class CourseNotFoundException extends RuntimeException
{
String msg;

public CourseNotFoundException(String msg)
{
this.msg=msg;
}

@Override
public String getMessage()
{
return msg;
}

}























/*package com.cg.mts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings("serial")
@ControllerAdvice
public class CourseNotFoundException extends Exception {
	@ExceptionHandler(value=CourseNotFoundException.class)
	public ResponseEntity<Object> exception(CourseNotFoundException exception){
		return new ResponseEntity<>("course not found",HttpStatus.NOT_FOUND);
	}


	
	
}
*/