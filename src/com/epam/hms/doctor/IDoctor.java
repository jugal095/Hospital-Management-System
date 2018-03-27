package com.epam.hms.doctor;

import java.util.List;

public interface IDoctor {
	int addDoctor(Doctor d);
	boolean updateDoctorAvailability(int doctorId,String status);
	List<Doctor> getDoctorsList();
	List<Doctor> getAllAvailableDoctors();
	List<Doctor> getAllUnAvailableDoctors();
	boolean searchDoctor(int doctorId);
	Doctor DoctorByDoctorId(int doctorId);
	
	
}
