package com.epam.hms.patient;

import java.util.List;

public interface IPatient {

	int addPatient(Patient p);
	String dischargePatient(int patientId);
	List<Patient> getPatientsList();
	List<Patient> getAllAdmittedPatients();
	List<Patient> getAllDischargePatients();
	void patientDetails(int patientId) throws Exception;
	
}
