package com.epam.hms.exceptions;



/*
 * CUSTOM EXCEPTION CLASS
 * */


@SuppressWarnings("serial")
public class DoctorDoesNotExistException extends Exception {

	public DoctorDoesNotExistException(String message) {
		super(message);
	}
}
