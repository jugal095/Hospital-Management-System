package com.epam.hms.exceptions;



/*
 * CUSTOM EXCEPTION CLASS
 * */

@SuppressWarnings("serial")
public class DoctorNotAvailableException extends Exception{

	public DoctorNotAvailableException(String message) {
		super(message);
	}
	
}
