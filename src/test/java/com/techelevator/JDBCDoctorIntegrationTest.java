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

import com.techelevator.dao.DoctorDAO;
import com.techelevator.dao.JDBCDoctorDAO;

public class JDBCDoctorIntegrationTest extends DAOIntegrationTest {
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	
	private DoctorDAO doctorDAO;

	@Before
	public void setup(){
		doctorDAO = new JDBCDoctorDAO(getDataSource());
	}
	
	@Test
	public void doctor_can_be_found_by_id_after_being_created(){
		Doctor doctor = new Doctor();
		doctor.setName("name");
		doctor.setOfficeId(1);
		doctor.setFee("$50");
		doctor.setHours("9:00AM-5:00PM");
		doctor.setAdmin(false);
		Doctor newDoctor = doctorDAO.addDoctor(doctor);
		assert_doctors_are_equal(newDoctor, doctorDAO.getDoctorById(newDoctor.getId()));
	}
	
	private void assert_doctors_are_equal(Doctor expectedDoctor, Doctor actualDoctor) {
		Assert.assertEquals("Doctor ids should match", expectedDoctor.getId(), actualDoctor.getId());
		Assert.assertEquals("Doctor names should match", expectedDoctor.getName(), actualDoctor.getName());
		Assert.assertEquals("Office ids should match", expectedDoctor.getOfficeId(), actualDoctor.getOfficeId());
		Assert.assertEquals("Fees should match", expectedDoctor.getFee(), actualDoctor.getFee());
		Assert.assertEquals("Hours should match", expectedDoctor.getHours(), actualDoctor.getHours());
		Assert.assertEquals("isAdmin should match", expectedDoctor.isAdmin(), actualDoctor.isAdmin());
	}
	
}