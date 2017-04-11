package com.techelevator.dao;

import java.util.Date;
import java.util.List;

import com.techelevator.Appointment;

public interface AppointmentDAO {
	public List<Appointment> getAllAppointmentsByDoctorId(int doctorId);
	public List<Appointment> getAllAppointmentsByPatientId(int patientId);
	public void createAppointment(Appointment appointment);
	public void updateAppointment(int appointmentId, int doctorId, int patientId, Date startDate, Date endDate);
	public void deleteAppointment(int appointmentId);
}
