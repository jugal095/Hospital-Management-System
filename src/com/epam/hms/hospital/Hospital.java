package com.epam.hms.hospital;

import java.util.*;


import com.epam.hms.doctor.Doctor;
import com.epam.hms.doctor.IDoctor;
import com.epam.hms.patient.IPatient;
import com.epam.hms.patient.Patient;

public class Hospital implements IDoctor,IPatient {

	List<Doctor> doctorsList=new ArrayList<Doctor>(); 			//List of all doctors
	List<Patient> patientsList=new ArrayList<Patient>();		//List of all patients
	
	/*
	 * Method to register patient
	 */
	
	@Override
	public int addPatient(Patient p) {
		patientsList.add(p);
		return p.getPatientId();
	}
	
	@Override
	public boolean dischargePatient(int patientId) {
		boolean found=false;
		for(Patient p:patientsList)
		{
			if(p.getPatientId()==patientId)
			{
				p.setStatus("Discharge");
				p.setDischargeDate(new Date());
				found=true;
			}
		}
		if(found==true)
		{
			return true;
		}
		
		return false;
		
	}

	@Override
	public int addDoctor(Doctor d) {
		doctorsList.add(d);
		return d.getDoctorId();
	}

	@Override
	public boolean updateDoctorAvailability(int doctorId, String status) {
		boolean update=false;
		for(Doctor d:doctorsList)
		{
			if(d.getDoctorId()==doctorId)
			{
				if(status.equalsIgnoreCase("y"))
				{
					d.setStatus(true);
					update=true;
				}
				else if(status.equalsIgnoreCase("n"))
				{
					d.setStatus(false);
					update=true;
				}
				else
				{
					update=false;
				}
			}
		}
		
		
		return update;
	}

	@Override
	public List<Patient> getPatientsList() {
		return patientsList;
	}

	@Override
	public List<Doctor> getDoctorsList() {
		return doctorsList;
	}

	@Override
	public List<Patient> getAllAdmittedPatients() {
		List<Patient> admitted =new ArrayList<>();
		for(Patient p:patientsList)
		{
			if(p.getStatus().equalsIgnoreCase("admit"));
			{
				admitted.add(p);
			}
		}
		return admitted;
	}

	@Override
	public List<Patient> getAllDischargePatients() {
		List<Patient> discharge =new ArrayList<>();
		for(Patient p:patientsList)
		{
			if(p.getStatus().equalsIgnoreCase("discharge"));
			{
				discharge.add(p);
			}
		}
		return discharge;
	}

	@Override
	public List<Doctor> getAllAvailableDoctors() {
		List<Doctor> avail=new ArrayList<>();
		for(Doctor d:doctorsList)
		{
			if(d.isStatus()==true)
			{
				avail.add(d);
			}
		}
		return avail;
	}

	@Override
	public List<Doctor> getAllUnAvailableDoctors() {
		List<Doctor> unavail=new ArrayList<>();
		for(Doctor d:doctorsList)
		{
			if(d.isStatus()==false)
			{
				unavail.add(d);
			}
		}
		return unavail;
	}

	@Override
	public boolean searchDoctor(int doctorId)
	{
		for(Doctor d:doctorsList)
		{
			if(d.getDoctorId()==doctorId)
			{
				return true;
			}
		}
		return false;
	}
	
	
}
