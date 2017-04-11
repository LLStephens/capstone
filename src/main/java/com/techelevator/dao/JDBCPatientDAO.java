package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Patient;

@Component
public class JDBCPatientDAO implements PatientDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCPatientDAO (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
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
	public Patient addPatient(Patient patient) {
		Long id = getNextId();
		
		String sqlAddPatient = "INSERT INTO patient(id, name, date_of_birth, address, phone_number, email) VALUES (?,?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlAddPatient, id, patient.getName(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), patient.getEmail());
		
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

}
