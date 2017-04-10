package com.techelevator.dao;

import java.util.List;

import com.techelevator.Patient;

public interface PatientDAO {
	public Patient getPatientById(int patientId);
	public List<Patient> getAllPatients();
	public Patient addPatient();
	public Patient updatePatient(int patientId);
	public void deletePatient(int patientId);
}
