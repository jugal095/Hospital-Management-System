package com.epam.hms.doctor;

public class Doctor {

	private int doctorId;
	private String doctorName;
	private String doctorSpeciality;
	private boolean status; 
	
	
	public Doctor(int doctorId, String doctorName, String doctorSpeciality, boolean status) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.status = status;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}
	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		String avail="NO";
		if(status==true)
		{
			avail="YES";
		}
		else
		{
			avail="NO";
		}
		
		return "\n-------------------------------------\nDoctor Id = " + doctorId + "\nDoctor Name = " + doctorName + "\nDoctor Speciality = " + doctorSpeciality+"\nAvailability = "+avail+ "\n-------------------------------------\n";
	}
	
	
	
	
}
