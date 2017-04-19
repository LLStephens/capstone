package com.techelevator.capstone.dao;

import java.util.List;

import com.techelevator.capstone.model.Patient;

public interface PatientDAO {
	public Patient getPatientById(int patientId);
	public List<Patient> getAllPatients();
	public Patient addPatient(Patient patient, String password);
	public void updatePatient(int patientId, String name, String dateOfBirth, String address, String phoneNumber, String email);
	public void deletePatient(int patientId);
	public int getIdByUsernameAndPassword(String user_name, String password);
	public boolean searchForUsernameAndPassword(String user_name, String password);
	public Patient savePatient(String name, String date_of_birth, String address, String phone_number, String email, String user_name, String password);
}
