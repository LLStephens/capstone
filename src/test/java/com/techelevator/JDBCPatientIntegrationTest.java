package com.techelevator;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.JDBCPatientDAO;
import com.techelevator.dao.PatientDAO;





public class JDBCPatientIntegrationTest extends DAOIntegrationTest {
	
	private PatientDAO patientDAO;
	
	@Before
	public void setup(){
		patientDAO = new JDBCPatientDAO(getDataSource());
	}
	
	@Test
	public void patient_can_be_found_by_id_after_being_created(){
		Patient patient = new Patient();
		patient.setName("patient");
		patient.setDateOfBirth("04/04/1994");
		patient.setAddress("1234 Address");
		patient.setPhoneNumber("555-555-5555");
		patient.setEmail("email@email.com");
		Patient newPatient = patientDAO.addPatient(patient);
		assert_patients_are_equal(newPatient, patientDAO.getPatientById(newPatient.getId()));
	}
	
	private void assert_patients_are_equal(Patient expectedPatient, Patient actualPatient) {
		Assert.assertEquals(expectedPatient.getId(), actualPatient.getId());
		Assert.assertEquals(expectedPatient.getName(), actualPatient.getName());
		Assert.assertEquals(expectedPatient.getDateOfBirth(), actualPatient.getDateOfBirth());
		Assert.assertEquals(expectedPatient.getAddress(), actualPatient.getAddress());
		Assert.assertEquals(expectedPatient.getPhoneNumber(), actualPatient.getPhoneNumber());
		Assert.assertEquals(expectedPatient.getEmail(), actualPatient.getEmail());
	}
	
}