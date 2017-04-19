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
	
	public String makePatientEmailBody(String reason){
		LocalDate apptDate = newAppt.getStartDate().toLocalDate();
		LocalTime apptTime = newAppt.getStartDate().toLocalTime();
		DayOfWeek apptWordDay = apptDate.getDayOfWeek();
		Month apptMonth = apptDate.getMonth();
		int apptNumDay = apptDate.getDayOfMonth();
		
		String emailBody = 
				"Your appointment for " + apptWordDay + " " + apptMonth + 
				" " + apptNumDay + " at " + fmt.format(apptTime) + " has been booked.  "
				+ "You selected a reason of " + reason + 
				" . Please complete the following instructions to prepare of this type of appointment: " + instructions(reason);
		
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
	
	public String instructions(String reason){
		String instructions = "";
		if(reason.equals("New patient")){
			instructions = "Please arrive 15 minutes early to complete new patient paperwork.  "
					+ "Bring with you a list of all current medications including prescription and over-the-counter drugs and vitamins.";
		} else if (reason.equals("Follow-up")){
			instructions = "You will be seeing the doctor to check up on the status of a current or recent condition.  "
					+ "Please be prepared to discuss and changes in your condition and any concerns you have.";
		} else if (reason.equals("Other")){
			instructions = "If you have not been to our office in the last 6 months, please arrive 15 minutes early to update your paperwork. "
					+ "Bring with you a list of all current medications including prescription and over-the-counter drugs and vitamins."
					+ "Otherwise, please arrive at the scheduled time above. Please call the office for any further questions.";
		}
		return instructions;
	}
	

}
	

