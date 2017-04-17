package com.techelevator.capstone;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.techelevator.capstone.dao.DoctorDAO;
import com.techelevator.capstone.model.Appointment;
import com.techelevator.capstone.model.Doctor;

public class Notification {
	private DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
	private Appointment newAppt; 	
	private DoctorDAO doctorDAO;
	
	public Notification (Appointment newAppt){
		this.newAppt = newAppt;
	}
	
	public String makePatientEmailBody(){
		LocalDate apptDate = newAppt.getStartDate().toLocalDate();
		LocalTime apptTime = newAppt.getStartDate().toLocalTime();
		DayOfWeek apptWordDay = apptDate.getDayOfWeek();
		Month apptMonth = apptDate.getMonth();
		int apptNumDay = apptDate.getDayOfMonth();
		
		String emailBody = "Your appointment for " + apptWordDay + " " + apptMonth + 
				" " + apptNumDay + " at " + fmt.format(apptTime) + " has been booked.";
		
		return emailBody;
	}
	
	public String makeDoctorEmailBody(){
		LocalDate apptDate = newAppt.getStartDate().toLocalDate();
		LocalTime apptTime = newAppt.getStartDate().toLocalTime();
		DayOfWeek apptWordDay = apptDate.getDayOfWeek();
		Month apptMonth = apptDate.getMonth();
		int apptNumDay = apptDate.getDayOfMonth();
	
		String emailBody = "An appointment for " + apptWordDay + " " + apptMonth + 
				" " + apptNumDay + " at " + fmt.format(apptTime) + " has been booked onto your schedule.";
		
		return emailBody;
	}
	
	

}
	

