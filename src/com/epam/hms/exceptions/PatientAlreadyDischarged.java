package com.epam.hms.exceptions;

@SuppressWarnings("serial")
public class PatientAlreadyDischarged  extends Exception {
	
	 public PatientAlreadyDischarged(String message) {
		 
		super(message);
	}

}
