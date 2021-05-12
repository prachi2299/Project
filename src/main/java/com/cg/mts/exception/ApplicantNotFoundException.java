package com.cg.mts.exception;

public class ApplicantNotFoundException extends Exception {
	String message;
	public ApplicantNotFoundException(String message)
	{
	this.message=message;
	}
	@Override
	public String getMessage()
	{
	return message;
	}
}
