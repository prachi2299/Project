package com.cg.mts.exception;

public class LoginFailedException extends Exception {
	String message;

	public LoginFailedException(String message) {
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}



}
