package com.techelevator;

import java.sql.SQLException;
import java.time.LocalTime;

import javax.sql.DataSource;

import org.apache.xerces.impl.dv.util.Base64;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.capstone.dao.JDBCPatientDAO;
import com.techelevator.capstone.dao.PatientDAO;
import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.model.Patient;
import com.techelevator.capstone.security.PasswordHasher;

public class JDBCPatientIntegrationTest extends DAOIntegrationTest {
	
	private PatientDAO patientDAO;
	private PasswordHasher passwordHasher;
	
	@Before
	public void setup(){
		passwordHasher = new PasswordHasher();
		patientDAO = new JDBCPatientDAO(getDataSource(), passwordHasher);
	}
	
//	@Test
//	public void patient_can_be_found_by_id_after_being_created(){
//		Patient patient = new Patient();
//		PasswordHasher password = new PasswordHasher();
//		byte[] salt = password.generateRandomSalt();
//		String saltString = new String(Base64.encode(salt));
//		patient.setName("patient");
//		patient.setDateOfBirth("04/04/1994");
//		patient.setAddress("1234 Address");
//		patient.setPhoneNumber("555-555-5555");
//		patient.setEmail("email@email.com");
//		patient.setUser_name("UserName");
//		patient.setSalt(saltString);
//		patient.setPassword(password.computeHash("12345ABCDe", salt));
//		Patient newPatient = patientDAO.addPatient(patient, patient.getPassword());
//		assert_patients_are_equal(newPatient, patientDAO.getPatientById(newPatient.getId()));
//	}
	
	@Test
	public void returns_true_if_doctor_userName_and_password_match() {
		Patient patient = new Patient();
//		long id = getNextId();
		PasswordHasher password = new PasswordHasher();
		byte[] salt = password.generateRandomSalt();
		String saltString = new String(Base64.encode(salt));
		patient.setName("patient");
		patient.setDateOfBirth("01/01/1990");
		patient.setAddress("123 Address");
		patient.setPhoneNumber("555-555-5555");
		patient.setEmail("email@email.com");
		patient.setUser_name("patient");
		patient.setPassword("12345ABCDe");
		patient.setSalt(saltString);
		patientDAO.addPatient(patient, "12345ABCDe");
		boolean result = patientDAO.searchForUsernameAndPassword("patient", "12345ABCDe");
		Assert.assertTrue(result);
	}
	
	private void assert_patients_are_equal(Patient expectedPatient, Patient actualPatient) {
		Assert.assertEquals(expectedPatient.getId(), actualPatient.getId());
		Assert.assertEquals(expectedPatient.getName(), actualPatient.getName());
		Assert.assertEquals(expectedPatient.getDateOfBirth(), actualPatient.getDateOfBirth());
		Assert.assertEquals(expectedPatient.getAddress(), actualPatient.getAddress());
		Assert.assertEquals(expectedPatient.getPhoneNumber(), actualPatient.getPhoneNumber());
		Assert.assertEquals(expectedPatient.getEmail(), actualPatient.getEmail());
		Assert.assertEquals(expectedPatient.getUser_name(), actualPatient.getUser_name());
		Assert.assertEquals(expectedPatient.getPassword(), actualPatient.getPassword());
		Assert.assertEquals(expectedPatient.getSalt(), actualPatient.getSalt());
	}
	
}