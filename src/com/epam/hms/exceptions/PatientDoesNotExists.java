package com.epam.hms.exceptions;

@SuppressWarnings("serial")
public class PatientDoesNotExists extends Exception {
	
	public PatientDoesNotExists(String message) {
		super(message);
	}
	
}
