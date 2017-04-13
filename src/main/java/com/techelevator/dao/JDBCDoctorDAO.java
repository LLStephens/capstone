package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Doctor;


@Component
public class JDBCDoctorDAO implements DoctorDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCDoctorDAO (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> allDoctors = new ArrayList<>();
		String sqlSelectAllDoctors = "SELECT * FROM doctor";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllDoctors);
		while(results.next()) {
			allDoctors.add(mapToRowToDoctor(results));
		}
		return allDoctors;
	}
	
	@Override
	public List<Doctor> getAllDoctorsByOfficeId(int officeId) {
		List<Doctor> allDoctorsByOffice = new ArrayList<>();
		String sqlSelectDoctorByOfficeId = "SELECT * FROM doctor WHERE office_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectDoctorByOfficeId, officeId);
		while(results.next()) {
			allDoctorsByOffice.add(mapToRowToDoctor(results));
		}
		return allDoctorsByOffice;
	}

	@Override
	public Doctor getDoctorById(int id) {
		String sqlSelectDoctorById = "SELECT * FROM doctor WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectDoctorById, id);
		while(results.next()) {
			 return mapToRowToDoctor(results);
		}
		return null;
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		Long id = getNextId();
		
		String sqlInsertDoctor = "INSERT INTO doctor(id, name, office_id, fee, hours, admin) VALUES (?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlInsertDoctor, id, doctor.getName(), doctor.getOfficeId(), doctor.getFee(), doctor.getHours(), doctor.isAdmin());
		
		if(rowsAffected == 1) {
			doctor.setId(id.intValue());
			return doctor;
		} else {
			return null;
		}
	}
	
	@Override
	public void updateDoctor(String name, String officeId, String fee, String hours, boolean admin) {
		jdbcTemplate.update("UPDATE doctor SET name = '"+name+"' office_id = '"+officeId+"' fee = '"+fee+"' hours = '"+hours+"' admin = '"+admin+"'");
	
	}

	@Override
	public void deleteDoctor(int doctorId) {
		String sqlDeleteDoctor = "DELETE * FROM doctor WHERE id = ?";
		jdbcTemplate.update(sqlDeleteDoctor, doctorId);
	}
	
	private Doctor mapToRowToDoctor (SqlRowSet row) {
		Doctor doctor = new Doctor();
		doctor.setId(row.getInt("id"));
		doctor.setAdmin(row.getBoolean("admin"));
		doctor.setFee(row.getString("fee"));
		doctor.setHours(row.getString("hours"));
		doctor.setName(row.getString("name"));
		doctor.setOfficeId(row.getInt("office_id"));
		return doctor;
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

	@Override
	public int getDoctorIdByUsernameAndPassword(String userName, String password) {
		int none = -1;
		String sqlSearchForDoctor = "SELECT * "+
								  "FROM doctor "+
								  "WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' "+
								  "AND password = '"+password+"'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForDoctor);
		if(results.next()) {
			return mapToRowToDoctor(results).getId();
		}else{
		return none;
		}
	}

	@Override
	public boolean searchDoctorForUsernameAndPassword(String userName, String password) {
		String sqlSearchForDoctor = "SELECT * "+
			      					"FROM doctor "+
			      					"WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' "+
			      					"AND password = '"+password+"'";

		return jdbcTemplate.queryForRowSet(sqlSearchForDoctor).next();
	}


	
}
