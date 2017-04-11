package com.techelevator.dao;

import java.util.List;

import com.techelevator.Patient;

public interface PatientDAO {
	public Patient getPatientById(int patientId);
	public List<Patient> getAllPatients();
	public void addPatient(Patient patient);
	public void updatePatient(int patientId, String name, String dateOfBirth, String address, String phoneNumber, String email);
	public void deletePatient(int patientId);
}
