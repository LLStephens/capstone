package com.techelevator.dao;

import java.util.List;

import com.techelevator.Doctor;

public interface DoctorDAO {
	public List<Doctor> getAllDoctorsByOfficeId(int officeId);
	public List<Doctor> getAllDoctors();
	public Doctor getDoctorById(int doctorId);
	public void addDoctor(Doctor doctor);
	public void deleteDoctor(int doctorId);
	void updateDoctor(String name, String officeId, String fee, String hours, boolean admin);
}
