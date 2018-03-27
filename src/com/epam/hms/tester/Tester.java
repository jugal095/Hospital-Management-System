package com.epam.hms.tester;


import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.epam.hms.doctor.Doctor;
import com.epam.hms.exceptions.DoctorDoesNotExistException;
import com.epam.hms.exceptions.DoctorNotAvailableException;
import com.epam.hms.exceptions.PatientAlreadyDischargedException;
import com.epam.hms.exceptions.PatientDoesNotExistsException;
import com.epam.hms.hospital.Hospital;
import com.epam.hms.patient.Patient;

/* 
 * Main CLass
 */

public class Tester {

	static int doctorCount;
	static int patientCount;

	static {
		doctorCount = 101;
		patientCount = 1001;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;

		Hospital h = new Hospital();
		List<Doctor> dlist = null;
		List<Patient> plist = null;

		System.out.println("__________________________________________");
		System.out.println("|*******HOSPITAL MANAGEMENT SYSTEM*******|");
		System.out.println("|________________________________________|");
		System.out.println();

		try (Scanner sc = new Scanner(System.in)) {
			
			while (exit == false) {
				System.out.println("__________________________________________");
				System.out.println("|*************** MAIN MENU **************|");
				System.out.println("|________________________________________|");
				System.out.println("| 1.  Register Doctor                    |");
				System.out.println("| 2.  Update Doctor                      |");
				System.out.println("| 3.  Admit Patient                      |");
				System.out.println("| 4.  Discharge Patient                  |");
				System.out.println("| 5.  Show All Doctors                   |");
				System.out.println("| 6.  Show All Patients                  |");
				System.out.println("| 7.  Show All Available Doctors         |");
				System.out.println("| 8.  Show All Unavailable Doctors       |");
				System.out.println("| 9.  Show All Admitted Patients         |");
				System.out.println("| 10. Show All Discharge Patients        |");
				System.out.println("| 11. Doctor Appointment                 |");
				System.out.println("| 12. Patient Details By Patient Id      |");
				System.out.println("| 0.  Exit                               |");
				System.out.println("|________________________________________|");
				System.out.println("| Please Select Your Choice              |");
				System.out.println("|________________________________________|");
				int choice=sc.nextInt();
				switch (choice) {
				case 1:															
					System.out.println("Enter Doctor's Name : ");
					String doctorName = sc.next();
					System.out.println("Enter Doctor's Speciality : ");
					String doctorSpecialization = sc.next();
					System.out.println("Doctor registed with Doctor ID "
							+ h.addDoctor(new Doctor(doctorCount, doctorName, doctorSpecialization, true)));
					doctorCount++;
					break;

				case 2:															
					System.out.println("Enter Doctor ID");
					int doctorId = sc.nextInt();
					try {
						if (h.searchDoctor(doctorId)) {
							System.out.println("Press y if doctor is available else press n");
							String avail = sc.next();
							if (h.updateDoctorAvailability(doctorId, avail)) {
								System.out.println("Doctor's Availabilty Updated");
							} else {
								System.out.println("Please Enter valid option");
							}

						} else {
							throw new DoctorDoesNotExistException("Invalid Doctor Id !!!!");
						}
					} catch (DoctorDoesNotExistException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					try {
						System.out.println("Enter Patient's Name : ");
						String patientName = sc.next();
						System.out.println("Enter Patient's age : ");
						int patientAge = sc.nextInt();
						System.out.println("Enter Patient's Gender : ");
						String patientGender = sc.next();
						System.out.println("Enter Patient Disease : ");
						String patientDisease = sc.next();
						System.out.println("Enter Room Number : ");
						int roomNumber = sc.nextInt();
						System.out.println("Enter Doctor ID: ");
						doctorId = sc.nextInt();
						if (h.searchDoctor(doctorId)) {
							if (h.DoctorByDoctorId(doctorId).isStatus() == true) {
								System.out.println("Patient registed with Patient ID " + h.addPatient(
										new Patient(patientCount, patientName, patientDisease, patientGender,
												patientAge, new Date(), null, "Admit", roomNumber, doctorId)));
								patientCount++;
							} else {
								throw new DoctorNotAvailableException(doctorId + " Doctor Not Available !!!!");
							}
						} else {
							throw new DoctorDoesNotExistException("Invalid Doctor Id !!!!");
						}
					} catch (DoctorDoesNotExistException | DoctorNotAvailableException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println("Enter Valid Information!!!!");
					}
					break;

				case 4:
					System.out.println("Enter Patient ID");
					int patientId = sc.nextInt();
					try {
						String dischargeStatus = h.dischargePatient(patientId);
						if (dischargeStatus.equals("discharge")) {
							System.out.println("Patient discharge !!!");

						} else if (dischargeStatus.equals("failed")) {
							throw new PatientDoesNotExistsException("Invalid Patien Id !!!!");
						} else if (dischargeStatus.equals("discharged")) {
							throw new PatientAlreadyDischargedException(patientId + " Patient Already discharge");
						}
					} catch (PatientDoesNotExistsException | PatientAlreadyDischargedException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					dlist = h.getDoctorsList();
					for (Doctor d1 : dlist) {
						System.out.println(d1.toString());
					}
					break;

				case 6:
					plist = h.getPatientsList();
					System.out.println(
							"Patient Id        Patient Name          Disease    Gender     Age        Status         Admit Date                             Discharge Date                    Room Number         Doctor ID");
					System.out.println(
							"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for (Patient p1 : plist) {
						System.out.println(p1.toString());
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}

					break;

				case 7:
					dlist = h.getAllAvailableDoctors();
					for (Doctor d1 : dlist) {
						System.out.println(d1.toString());
					}
					break;

				case 8:
					dlist = h.getAllUnAvailableDoctors();
					for (Doctor d1 : dlist) {
						System.out.println(d1.toString());
					}
					break;

				case 9:
					plist = h.getAllAdmittedPatients();
					System.out.println(
							"Patient Id        Patient Name          Disease    Gender     Age        Status         Admit Date                             Discharge Date                    Room Number         Doctor ID");
					System.out.println(
							"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for (Patient p1 : plist) {
						System.out.println(p1.toString());
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}

					break;

				case 10:
					plist = h.getAllDischargePatients();

					System.out.println(
							"Patient Id        Patient Name          Disease    Gender     Age        Status         Admit Date                             Discharge Date                    Room Number         Doctor ID");
					System.out.println(
							"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for (Patient p1 : plist) {
						System.out.println(p1.toString());
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}

					break;

				case 11:
					try {
						System.out.println("Enter Patient's Name : ");
						String patientName = sc.next();
						System.out.println("Enter Patient's age : ");
						int patientAge = sc.nextInt();
						System.out.println("Enter Patient's Gender : ");
						String patientGender = sc.next();
						System.out.println("Enter Patient Disease : ");
						String patientDisease = sc.next();
						System.out.println("Enter Room Number : ");
						int roomNumber = sc.nextInt();
						System.out.println("Enter Doctor ID: ");
						doctorId = sc.nextInt();
						if (h.searchDoctor(doctorId)) {
							if (h.DoctorByDoctorId(doctorId).isStatus() == true) {
								System.out.println(
										"Patient registed with Patient ID " + h.addPatient(new Patient(patientCount,
												patientName, patientDisease, patientGender, patientAge, new Date(),
												new Date(), "Appointment", roomNumber, doctorId)));
								patientCount++;
							} else {
								throw new DoctorNotAvailableException(doctorId + " Doctor Not Available !!!!");
							}

						} else {
							throw new DoctorDoesNotExistException("Invalid Doctor Id !!!!");
						}
					} catch (DoctorDoesNotExistException | DoctorNotAvailableException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.err.println("Enter Valid Information!!!!");
					}

					break;
				case 12:
					try {
						System.out.println("Enter Patient Id :");
						patientId = sc.nextInt();
						h.patientDetails(patientId);
					} catch (PatientDoesNotExistsException e) {
						System.err.println(e.getMessage());
					}
					break;
				case 0:
					exit = true;
					System.out.println("*****GOOD BYE!!!!!*****");
					break;

				default:
					System.out.println("*****PLEASE ENTER A VALID CHOICE*****");
					break;
				}

			}

		}

	}

}
