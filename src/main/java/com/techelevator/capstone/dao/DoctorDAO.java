package com.techelevator.capstone.dao;

import java.util.List;

import com.techelevator.capstone.model.Doctor;

public interface DoctorDAO {
	public List<Doctor> getAllDoctorsByOfficeId(int officeId);
	public List<Doctor> getAllDoctors();
	public Doctor getDoctorById(int doctorId);
	public Doctor addDoctor(Doctor doctor);
	public void deleteDoctor(int doctorId);
	public void updateDoctor(String name, int officeId, String fee, String hours, boolean admin, String email);
	public int getDoctorIdByUsernameAndPassword(String user_name, String password);
	public boolean searchDoctorForUsernameAndPassword(String user_name, String password);
	public void updateDoctorFee(String fee, int doctorId);
	public void updateDoctorPassword(String password, int doctorId);
}
