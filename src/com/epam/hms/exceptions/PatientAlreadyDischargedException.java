package com.epam.hms.exceptions;


/*
 * CUSTOM EXCEPTION CLASS
 * */

@SuppressWarnings("serial")
public class PatientAlreadyDischargedException  extends Exception {
	
	 public PatientAlreadyDischargedException(String message) {
		 
		super(message);
	}

}
