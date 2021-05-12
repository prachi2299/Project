package com.cg.mts.exception;

public class AdmissionNotGrantedException extends Exception {

	String message;

	public AdmissionNotGrantedException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	

}
