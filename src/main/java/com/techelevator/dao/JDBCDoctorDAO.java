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
	public void addDoctor(Doctor doctor) {
		String sqlInsertDoctor = "INSERT INTO doctor(name, office_id, fee, hours, admin) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertDoctor, doctor.getName(), doctor.getOfficeId(), doctor.getFee(), doctor.getHours(), doctor.isAdmin());
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
		return doctor;
	}


	
}
