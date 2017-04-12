package com.techelevator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.dao.AppointmentDAO;
import com.techelevator.dao.JDBCAppointmentDAO;
import com.techelevator.dao.JDBCOfficeDAO;
import com.techelevator.dao.OfficeDAO;

public class JDBCAppointmentIntegrationTest extends DAOIntegrationTest {

	private AppointmentDAO appointmentDAO;
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@Before
	public void setup(){
		appointmentDAO = new JDBCAppointmentDAO(getDataSource());
	}
	
	@Test
	public void appointment_can_be_found_by_id_after_being_created(){
		Appointment appointment = new Appointment();
		LocalDateTime startDate = LocalDateTime.of(2017, 04, 01, 12, 43);
		LocalDateTime endDate = LocalDateTime.of(2017, 05, 01, 12, 43);
		appointment.setDoctorId(2);
		appointment.setPatientId(3);
		appointment.setStartDate(startDate);
		appointment.setEndDate(endDate);
		Appointment newAppointment = appointmentDAO.createAppointment(appointment);
		assert_appointments_are_equal(newAppointment, appointmentDAO.getAppointmentById(newAppointment.getId()));
	}
	
	private void assert_appointments_are_equal(Appointment expectedAppointment, Appointment actualAppointment) {
		Assert.assertEquals(expectedAppointment.getId(), actualAppointment.getId());
		Assert.assertEquals(expectedAppointment.getDoctorId(), actualAppointment.getDoctorId());
		Assert.assertEquals(expectedAppointment.getPatientId(), actualAppointment.getPatientId());
		Assert.assertEquals(expectedAppointment.getStartDate(), actualAppointment.getStartDate());
		Assert.assertEquals(expectedAppointment.getEndDate(), actualAppointment.getEndDate());
		
	}
}
