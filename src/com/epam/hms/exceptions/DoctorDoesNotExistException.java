package com.epam.hms.exceptions;

@SuppressWarnings("serial")
public class DoctorDoesNotExistException extends Exception {

	public DoctorDoesNotExistException(String message) {
		super(message);
	}
}
