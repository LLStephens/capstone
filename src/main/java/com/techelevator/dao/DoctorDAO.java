package com.techelevator.dao;

import java.util.List;

import com.techelevator.Doctor;

public interface DoctorDAO {
	public List<Doctor> getAllDoctorsByOfficeId(int officeId);
	public List<Doctor> getAllDoctors();
	public Doctor getDoctorById(int doctorId);
	public Doctor addDoctor(int officeId);
	public Doctor updateDoctor(int doctorId);
	public void deleteDoctor(int doctorId);
}
