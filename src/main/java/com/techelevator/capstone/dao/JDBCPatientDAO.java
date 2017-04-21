package com.techelevator.capstone.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.capstone.model.Patient;
import com.techelevator.capstone.security.PasswordHasher;

@Component
public class JDBCPatientDAO implements PatientDAO {
	
	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;
	
	@Autowired
	public JDBCPatientDAO (DataSource datasource, PasswordHasher passwordHasher) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
		this.passwordHasher = passwordHasher;
	}
	
	@Override
	public Patient getPatientById(int patientId) {
		String sqlSelectPatientById = "SELECT * FROM patient WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPatientById, patientId);
		while(results.next()) {
			return mapToRowToPatient(results);
		}
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> allPatients = new ArrayList<>();
		String sqlSelectAllPatients = "SELECT * FROM patient";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPatients);
		while(results.next()) {
			allPatients.add(mapToRowToPatient(results));
		}
		return allPatients;
	}

	@Override
	public Patient addPatient(Patient patient, String password) {
		Long id = getNextId();
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		
		String sqlAddPatient = "INSERT INTO patient(id, name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES (?,?,?,?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlAddPatient, id, patient.getName(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), patient.getEmail(), patient.getUser_name(), hashedPassword, saltString);
		
		if(rowsAffected == 1) {
			patient.setId(id.intValue());
			return patient;
		} else {
			return null;
		}

	}

	@Override
	public void updatePatient(int patientId, String name, String dateOfBirth, String address, String phoneNumber, String email) {
		jdbcTemplate.update("UPDATE patient SET name = '"+name+"' date_of_birth = '"+dateOfBirth+"' address = '"+address+"' phone_number = '"+phoneNumber+"' email = '"+email+"' WHERE id = '"+patientId+"'");
	}

	@Override
	public void deletePatient(int patientId) {
		String sqlDeletePatient = "DELETE * FROM patient WHERE id = ?";
		jdbcTemplate.update(sqlDeletePatient, patientId);	
	}
	
	private Patient mapToRowToPatient (SqlRowSet row) {
		Patient patient = new Patient();
		patient.setId(row.getInt("id"));
		patient.setName(row.getString("name"));
		patient.setDateOfBirth(row.getString("date_of_birth"));
		patient.setAddress(row.getString("address"));
		patient.setPhoneNumber(row.getString("phone_number"));
		patient.setEmail(row.getString("email"));
		patient.setUser_name(row.getString("user_name"));
		patient.setPassword(row.getString("password"));
		return patient;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('patient_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next order id");
		}
	}

	@Override
	public boolean searchForUsernameAndPassword(String userName, String password) {
		String sqlSearchForUser = "SELECT * "+
								"FROM patient "+
								"WHERE UPPER(user_name) = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(hashedPassword);
		} else {
			return false;
		}
	
		
//		String sqlSearchForUser = "SELECT * "+
//							      "FROM patient "+
//							      "WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' "+
//							      "AND password = '"+password+"'";
//		
//		return jdbcTemplate.queryForRowSet(sqlSearchForUser).next();
	}

	@Override
	public Patient savePatient(String name, String date_of_birth, String address, String phone_number, String email, String user_name, String password) {
		Long id = getNextId();
		Patient patient = new Patient();
		
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		
		String sqlSavePatient = "INSERT INTO patient(id, name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES (?,?,?,?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlSavePatient, id, name, date_of_birth, address, phone_number, email, user_name, hashedPassword, saltString);
		
		if(rowsAffected == 1) {
			patient.setId(id.intValue());
			return patient;
		} else {
			return null;
		}
	}

	@Override
	public int getIdByUsernameAndPassword(String userName, String password) {
		
		int ptId = -1;
		String sqlSearchForPatient = "SELECT * " +
									"FROM patient "+
									"WHERE UPPER(user_name) = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForPatient, userName.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			if(storedPassword.equals(hashedPassword)) {
				ptId = (int) mapToRowToPatient(results).getId();
			}else{
				ptId = -1;
			}
		}
		return ptId;
	}

}
