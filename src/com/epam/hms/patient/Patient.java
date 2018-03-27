package com.epam.hms.patient;


import java.util.Date;

import com.epam.hms.hospital.Hospital;

public class Patient {
		
	private int patientId;
	private String patientName;
	private  String disease;
	private String gender;
	private int age;
	private Date admitDate;
	private Date dischargeDate;
	private String status;
	private int roomNumber;
	private int doctorId;
	
	
	
	public Patient(int patientId, String patientName, String disease, String gender, int age, Date admitDate,
			Date dischargeDate, String status,int roomNumber,int doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.disease = disease;
		this.gender = gender;
		this.age = age;
		this.admitDate = admitDate;
		this.dischargeDate = dischargeDate;
		this.status = status;
		this.roomNumber=roomNumber;
		this.doctorId=doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {   
		return patientId + "             " + patientName + "                 " + disease + "         "+ gender + "    " + age + "          "+ status+"        "+admitDate+"         "+dischargeDate+"                "+roomNumber+"        "+new Hospital().DoctorByDoctorId(doctorId);
	}
	
}
