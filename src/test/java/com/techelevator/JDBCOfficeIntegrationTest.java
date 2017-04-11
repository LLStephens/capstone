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

import com.techelevator.dao.JDBCOfficeDAO;
import com.techelevator.dao.OfficeDAO;



public class JDBCOfficeIntegrationTest extends DAOIntegrationTest {

	private OfficeDAO officeDAO;
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@Before
	public void setup(){
		officeDAO = new JDBCOfficeDAO(getDataSource());
	}
	
	@Test
	public void office_can_be_found_by_id_after_being_created(){
		Office office = new Office();
		office.setAddress("123 Address");
		office.setPhoneNumber("555-555-5555");
		office.setImageName("office");
		office.setHours("8:00AM-9:00PM");
		office.setName("The OFFICE");
		Office newOffice = officeDAO.addOffice(office);
		assert_offices_are_equal(newOffice, officeDAO.getOfficeById(newOffice.getId()));
	}
	
	private void assert_offices_are_equal(Office expectedOffice, Office actualOffice) {
		Assert.assertEquals(expectedOffice.getId(), actualOffice.getId());
		Assert.assertEquals(expectedOffice.getAddress(), actualOffice.getAddress());
		Assert.assertEquals(expectedOffice.getPhoneNumber(), actualOffice.getPhoneNumber());
		Assert.assertEquals(expectedOffice.getImageName(), actualOffice.getImageName());
		Assert.assertEquals(expectedOffice.getHours(), actualOffice.getHours());
		Assert.assertEquals(expectedOffice.getName(), actualOffice.getName());
	}
	
}
