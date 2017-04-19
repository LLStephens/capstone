package com.techelevator.capstone.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.model.Office;
import com.techelevator.capstone.security.PasswordHasher;


@Component
public class JDBCDoctorDAO implements DoctorDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;
	
	@Autowired
	public JDBCDoctorDAO (DataSource datasource, PasswordHasher passwordHasher) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
		this.passwordHasher = passwordHasher;
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
	public Doctor addDoctor(Doctor doctor, String password) {
		Long id = getNextId();
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
	
		String sqlInsertDoctor = "INSERT INTO doctor(id, name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlInsertDoctor, id, doctor.getName(), doctor.getOfficeId(), doctor.getFee(), doctor.getStartTime(), doctor.getEndTime(), doctor.isAdmin(), doctor.getUser_name(), hashedPassword, doctor.getEmail(), saltString);
		
		if(rowsAffected == 1) {
			doctor.setId(id.intValue());
			return doctor;
		} else {
			return null;
		}
	}
	
	@Override
	public List<Integer> getTopDoctorsByAverageRatingLimit5(){
		List<Integer> topDoctorIds = new ArrayList<>();
		String sqlGetTopDoctorIds = "select doctor_id from review group by doctor_id order by AVG(rating) desc limit 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTopDoctorIds);
	
		while(results.next()) {
			topDoctorIds.add(results.getInt("doctor_id"));
		}
		return topDoctorIds;
	}
	
	@Override
	public List<Integer> getTopDoctorRatingsByAverageRatingLimit5(){
		List<Integer> topDoctorRatings = new ArrayList<>();
		String sqlGetTopDoctorRatings = "select AVG(rating) from review group by doctor_id order by AVG(rating) desc limit 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTopDoctorRatings);
	
		while(results.next()) {
			topDoctorRatings.add(results.getInt("rating"));
		}
		return topDoctorRatings;
	}
	
	@Override
	public void updateDoctor(String name, int officeId, String fee, String hours, boolean admin, String email) {
		jdbcTemplate.update("UPDATE doctor SET name = '"+name+"' office_id = '"+officeId+"' fee = '"+fee+"' hours = '"+hours+"' admin = '"+admin+"'email = '"+email+"'");
	}

	@Override
	public void updateDoctorFee(String fee, int doctorId) {
		String sqlUpdateDoctorFee = "UPDATE doctor " +
			"SET fee = ? " +
			"WHERE id = ?";
	jdbcTemplate.update(sqlUpdateDoctorFee, fee, doctorId);
	}
	
	@Override
	public void updateDoctorPassword(String password, int doctorId) {
		String sqlUpdateDoctorPassword = "UPDATE doctor " +
			"SET password = ? " +
			"WHERE id = ?";
	jdbcTemplate.update(sqlUpdateDoctorPassword, password, doctorId);
	}

	@Override
	public void deleteDoctor(int doctorId) {
		String sqlDeleteDoctor = "DELETE * FROM doctor WHERE id = ?";
		jdbcTemplate.update(sqlDeleteDoctor, doctorId);
	}
	
	private Doctor mapToRowToDoctor (SqlRowSet row) {
		Doctor doctor = new Doctor();
		doctor.setId(row.getLong("id"));
		doctor.setAdmin(row.getBoolean("admin"));
		doctor.setFee(row.getString("fee"));
		doctor.setStartTime(row.getTime("start_time").toLocalTime());
		doctor.setEndTime(row.getTime("end_time").toLocalTime());
		doctor.setName(row.getString("name"));
		doctor.setOfficeId(row.getInt("office_id"));
		doctor.setEmail(row.getString("email"));
		doctor.setUser_name(row.getString("user_name"));
		doctor.setPassword(row.getString("password"));
		doctor.setSalt(row.getString("salt"));
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
		int docId = -1;
		String sqlSearchForDoctor = "SELECT * " +
									"FROM doctor "+
									"WHERE UPPER(user_name) = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForDoctor, userName.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			if(storedPassword.equals(hashedPassword)) {
				docId = (int) mapToRowToDoctor(results).getId();
			}else{
				docId = -1;
			}
		}
		return docId;
		
//		String sqlSearchForDoctor = "SELECT * "+
//								  "FROM doctor "+
//								  "WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' "+
//								  "AND password = '"+password+"'";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForDoctor);
//		if(results.next()) {
//			return mapToRowToDoctor(results).getId();
//		}else{
//			return -1;
//		}
	}

	@Override
	public boolean searchDoctorForUsernameAndPassword(String userName, String password) {
		String sqlSearchForDoctor = "SELECT * "+
									"FROM doctor "+			
									"WHERE UPPER(user_name) = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForDoctor, userName.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(hashedPassword);
		} else {
			return false;
		}
								
	}
//		String sqlSearchForDoctor = "SELECT * "+
//			      					"FROM doctor "+
//			      					"WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' "+
//			      					"AND password = '"+password+"'";
//
//		return jdbcTemplate.queryForRowSet(sqlSearchForDoctor).next();
//	}
}
