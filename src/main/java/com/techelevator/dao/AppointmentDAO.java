package com.techelevator.dao;

import java.util.List;

import com.techelevator.Appointment;

public interface AppointmentDAO {
	public List<Appointment> getAllAppointmentsByDoctorId(int doctorId);
	public List<Appointment> getAllAppointmentsByPatientId(int patientId);
	public void createAppointment(int patientId, int doctorId);
	public void updateAppointment(int appointmentId);
	public void deleteAppointment(int appointmentId);
}
