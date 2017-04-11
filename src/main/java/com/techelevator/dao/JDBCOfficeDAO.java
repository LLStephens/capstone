package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Office;

@Component
public class JDBCOfficeDAO implements OfficeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCOfficeDAO (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Office> getAllOffices() {
		List<Office> allOffices = new ArrayList<>();
		String sqlSelectAllOffices = "SELECT * FROM office";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllOffices);
		while(results.next()) {
			allOffices.add(mapToRowToOffice(results));
		}
		return allOffices;
	}

	@Override
	public Office getOfficeById(int officeId) {
		String sqlSelectOfficeById = "SELECT * FROM office WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOfficeById, officeId);
		while(results.next()) {
			 return mapToRowToOffice(results);
		}
		return null;
	}

	@Override
	public void addOffice(Office office) {
		String sqlInsertOffice = "INSERT INTO office(address, phone_number, image_name, hours, name) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertOffice, office.getAddress(), office.getPhoneNumber(), office.getImageName(), office.getHours(), office.getName());
	}
	
	@Override
	public void updateOffice(int officeId, String address, String phoneNumber, String imageName, String hours, String name) {
		jdbcTemplate.update("UPDATE office SET address = '"+address+"' phone_number = '"+phoneNumber+"' image_name = '"+imageName+"' hours = '"+hours+"' name = '"+name+"' WHERE id = '"+officeId+"'");
	}

	@Override
	public void deleteOffice(int officeId) {
		String sqlDeleteOffice = "DELETE * FROM office WHERE id = ?";
		jdbcTemplate.update(sqlDeleteOffice, officeId);
	}
	private Office mapToRowToOffice (SqlRowSet row) {
		Office office = new Office();
		office.setId(row.getInt("id"));
		office.setAddress(row.getString("address"));
		office.setPhoneNumber(row.getString("phone_number"));
		office.setImageName(row.getString("image_name"));
		office.setHours(row.getString("hours"));
		office.setName(row.getString("name"));
		return office;
	}
	
}
