package com.epam.hms.hospital;

import java.util.*;

import com.epam.hms.doctor.Doctor;
import com.epam.hms.doctor.IDoctor;
import com.epam.hms.exceptions.PatientDoesNotExistsException;
import com.epam.hms.patient.IPatient;
import com.epam.hms.patient.Patient;

public class Hospital implements IDoctor, IPatient {

	List<Doctor> doctorsList = new ArrayList<Doctor>(); // List of all doctors
	List<Patient> patientsList = new ArrayList<Patient>(); // List of all
															// patients

	/*
	 * Method to Admit patient
	 */

	@Override
	public int addPatient(Patient p) {
		patientsList.add(p);
		return p.getPatientId();
	}

	/*
	 * Method to Discharge patient
	 */

	@Override
	public String dischargePatient(int patientId) {
		String dischargeStatus = null;
		boolean found = false;
		for (Patient p : patientsList) {
			if (p.getPatientId() == patientId) {
				if (!p.getStatus().equalsIgnoreCase("Discharge")) {
					p.setStatus("Discharge");
					p.setDischargeDate(new Date());
					dischargeStatus = "discharge";
					found = true;
				} else {
					dischargeStatus = "discharged";
				}

			}
		}
		if (found == false) {
			dischargeStatus = "failed";
		}

		return dischargeStatus;

	}

	/*
	 * Method to Add Doctor
	 */

	@Override
	public int addDoctor(Doctor d) {
		doctorsList.add(d);
		return d.getDoctorId();
	}

	/*
	 * Method to Update Availability Status of doctor
	 */

	@Override
	public boolean updateDoctorAvailability(int doctorId, String status) {
		boolean update = false;
		for (Doctor d : doctorsList) {
			if (d.getDoctorId() == doctorId) {
				if (status.equalsIgnoreCase("y")) {
					d.setStatus(true);
					update = true;
				} else if (status.equalsIgnoreCase("n")) {
					d.setStatus(false);
					update = true;
				} else {
					update = false;
				}
			}
		}

		return update;
	}

	/*
	 * Method to show All Patients
	 * 
	 * @see com.epam.hms.patient.IPatient#getPatientsList()
	 */

	@Override
	public List<Patient> getPatientsList() {
		return patientsList;
	}

	/*
	 * Method to Show All Doctors
	 * 
	 * @see com.epam.hms.doctor.IDoctor#getDoctorsList()
	 */

	@Override
	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}

	/*
	 * Method to show All Admitted Patients(non-Javadoc)
	 * 
	 * @see com.epam.hms.patient.IPatient#getAllAdmittedPatients()
	 */

	@Override
	public List<Patient> getAllAdmittedPatients() {
		List<Patient> admitted = new ArrayList<>();
		for (Patient p : patientsList) {
			if (p.getStatus().equalsIgnoreCase("admit"))
				;
			{
				admitted.add(p);
			}
		}
		return admitted;
	}

	/*
	 * Method to show All Discharge Patients(non-Javadoc)
	 * 
	 * @see com.epam.hms.patient.IPatient#getAllDischargePatients()
	 */

	@Override
	public List<Patient> getAllDischargePatients() {
		List<Patient> discharge = new ArrayList<>();
		for (Patient p : patientsList) {
			if (p.getStatus().equalsIgnoreCase("discharge"))
				;
			{
				discharge.add(p);
			}
		}
		return discharge;
	}

	/*
	 * Method to show only available doctors
	 * 
	 * @see com.epam.hms.doctor.IDoctor#getAllAvailableDoctors()
	 */

	@Override
	public List<Doctor> getAllAvailableDoctors() {
		List<Doctor> avail = new ArrayList<>();
		for (Doctor d : doctorsList) {
			if (d.isStatus() == true) {
				avail.add(d);
			}
		}
		return avail;
	}

	/*
	 * Method to show only unavailable doctors
	 * 
	 * @see com.epam.hms.doctor.IDoctor#getAllUnAvailableDoctors()
	 */

	@Override
	public List<Doctor> getAllUnAvailableDoctors() {
		List<Doctor> unavail = new ArrayList<>();
		for (Doctor d : doctorsList) {
			if (d.isStatus() == false) {
				unavail.add(d);
			}
		}
		return unavail;
	}

	/*
	 * Method to check for doctor exists or not (non-Javadoc)
	 * 
	 * @see com.epam.hms.doctor.IDoctor#searchDoctor(int)
	 */

	@Override
	public boolean searchDoctor(int doctorId) {
		for (Doctor d : doctorsList) {
			if (d.getDoctorId() == doctorId) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Method to get Doctor by doctorId (non-Javadoc)
	 * 
	 * @see com.epam.hms.doctor.IDoctor#DoctorByDoctorId(int)
	 */

	@Override
	public Doctor DoctorByDoctorId(int doctorId) {
		for (Doctor d : doctorsList) {
			if (d.getDoctorId() == doctorId) {
				return d;
			}
		}
		return null;
	}

	/*
	 * Method to return details of Individual Patients
	 * 
	 * @see com.epam.hms.patient.IPatient#patientDetails(int)
	 */

	@SuppressWarnings("unused")
	@Override
	public void patientDetails(int patientId) throws PatientDoesNotExistsException {
		Patient p1 = null;
		Doctor d = null;
		for (Patient p : patientsList) {
			if (p.getPatientId() == patientId)
				;
			{
				p1 = p;
				break;
			}
		}
		d = DoctorByDoctorId(p1.getDoctorId());

		if (p1 != null) {
			System.out.println("Patient Id - " + p1.getPatientId());
			System.out.println("Patient Name - " + p1.getPatientName());
			System.out.println("Age - " + p1.getAge());
			System.out.println("Gender - " + p1.getGender());
			System.out.println("Disease - " + p1.getDisease());
			System.out.println("Status - " + p1.getStatus());
			System.out.println("Admit Date - " + p1.getAdmitDate());
			System.out.println("Discharge Date- " + p1.getDischargeDate());
			System.out.println("Doctor Id - " + d.getDoctorId());
			System.out.println("Doctor Name - " + d.getDoctorName());
			System.out.println("Doctor Speciality - " + d.getDoctorSpeciality());
		} else {
			throw new PatientDoesNotExistsException("Invalid Patient Id !!!!");
		}

	}

}
