package com.techelevator.capstone.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Appointment {
	private int id;
	private int doctorId;
	private int patientId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String message;
	private LocalTime startTime;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public LocalTime getStartTime() {
		
		return this.startTime;
	}
	public void setStartTime(LocalTime startTime) {
		LocalTime start = startDate.toLocalTime();
		this.startTime = start;
	}
	
	
}
