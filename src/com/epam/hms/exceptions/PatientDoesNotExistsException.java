package com.epam.hms.exceptions;

/*
 * CUSTOM EXCEPTION CLASS
 * */

@SuppressWarnings("serial")
public class PatientDoesNotExistsException extends Exception {
	
	public PatientDoesNotExistsException(String message) {
		super(message);
	}
	
}
