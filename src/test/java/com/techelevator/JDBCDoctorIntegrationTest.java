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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.capstone.dao.DoctorDAO;
import com.techelevator.capstone.dao.JDBCDoctorDAO;
import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.security.PasswordHasher;

public class JDBCDoctorIntegrationTest extends DAOIntegrationTest {
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	
	private DoctorDAO doctorDAO;
	private PasswordHasher passwordHasher;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setup(){
		passwordHasher = new PasswordHasher();
		doctorDAO = new JDBCDoctorDAO(getDataSource(), passwordHasher);
	}
	
//	@Test
//	public void doctor_can_be_found_by_id_after_being_created(){
//		Doctor doctor = new Doctor();
//		PasswordHasher password = new PasswordHasher();
//		LocalTime startTime = LocalTime.of(7, 00);
//		LocalTime endTime = LocalTime.of(15, 00);
//		byte[] salt = password.generateRandomSalt();
//		String saltString = new String(Base64.encode(salt));
//		doctor.setName("name");
//		doctor.setOfficeId(1);
//		doctor.setFee("$50");
//		doctor.setAdmin(false);
//		doctor.setStartTime(startTime);
//		doctor.setEndTime(endTime);
//		doctor.setUser_name("drdoctor");
//		doctor.setSalt(saltString);
//		doctor.setPassword(password.computeHash("12345ABCDe", salt));
//		doctor.setEmail("doctor@doctor.com");
//		Doctor newDoctor = doctorDAO.addDoctor(doctor, doctor.getPassword());
//		assert_doctors_are_equal(newDoctor, doctorDAO.getDoctorById(newDoctor.getId()));
//	}
	
	@Test
	public void returns_true_if_doctor_userName_and_password_match() {
		Doctor doctor = new Doctor();
//		long id = getNextId();
		LocalTime startTime = LocalTime.of(7, 00);
		LocalTime endTime = LocalTime.of(15, 00);
		PasswordHasher password = new PasswordHasher();
		byte[] salt = password.generateRandomSalt();
		String saltString = new String(Base64.encode(salt));
		doctor.setName("drdoctor");
//		doctor.setId(id);
		doctor.setOfficeId(1);
		doctor.setFee("$50");
		doctor.setStartTime(startTime);
		doctor.setEndTime(endTime);
		doctor.setAdmin(false);
		doctor.setUser_name("drdoctor");
		doctor.setPassword("doctorNUmber1");
		doctor.setEmail("email@email.com");
		doctor.setSalt(saltString);
		doctorDAO.addDoctor(doctor, "doctorNUmber1");
		boolean result = doctorDAO.searchDoctorForUsernameAndPassword("drdoctor", "doctorNUmber1");
		Assert.assertTrue(result);
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('doctor_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next order id");
		}
	}

	private void assert_doctors_are_equal(Doctor expectedDoctor, Doctor actualDoctor) {
		Assert.assertEquals("Doctor ids should match", expectedDoctor.getId(), actualDoctor.getId());
		Assert.assertEquals("Doctor names should match", expectedDoctor.getName(), actualDoctor.getName());
		Assert.assertEquals("Office ids should match", expectedDoctor.getOfficeId(), actualDoctor.getOfficeId());
		Assert.assertEquals("Fees should match", expectedDoctor.getFee(), actualDoctor.getFee());
		Assert.assertEquals("Hours should match", expectedDoctor.getStartTime(), actualDoctor.getStartTime());
		Assert.assertEquals("Hours should match", expectedDoctor.getEndTime(), actualDoctor.getEndTime());
		Assert.assertEquals("isAdmin should match", expectedDoctor.isAdmin(), actualDoctor.isAdmin());
		Assert.assertEquals(expectedDoctor.getUser_name(), actualDoctor.getUser_name());
		Assert.assertEquals(expectedDoctor.getPassword(), actualDoctor.getPassword());
		Assert.assertEquals(expectedDoctor.getEmail(), actualDoctor.getEmail());
	}
	
}