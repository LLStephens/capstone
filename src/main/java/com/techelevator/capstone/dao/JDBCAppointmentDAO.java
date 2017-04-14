package com.techelevator.capstone.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.capstone.model.Appointment;

@Component
public class JDBCAppointmentDAO implements AppointmentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCAppointmentDAO (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Appointment> getAllAppointmentsByDoctorId(int doctorId) {
		List<Appointment> allAppointmentsByDoctorId = new ArrayList<>();
		String sqlSelectAllAppointmentsByDoctorId = "SELECT * FROM appointment WHERE doctor_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllAppointmentsByDoctorId, doctorId);
		while(results.next()) {
			allAppointmentsByDoctorId.add(mapToRowToAppointment(results));
		}
		return allAppointmentsByDoctorId;
	}
	

	@Override
	public List<Appointment> getAllAppointmentsByPatientId(int patientId) {
		List<Appointment> allAppointmentsByPatientId = new ArrayList<>();
		String sqlSelectAllAppointmentsByPatientId = "SELECT * FROM appointment WHERE patient_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllAppointmentsByPatientId, patientId);
		while(results.next()) {
			allAppointmentsByPatientId.add(mapToRowToAppointment(results));
		}
		return allAppointmentsByPatientId;
	}
	
	@Override
	public Appointment getAppointmentById(int appointmentId) {
		String sqlSelectReviewById = "SELECT * FROM appointment WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectReviewById, appointmentId);
		while(results.next()) {
			 return mapToRowToAppointment(results);
		}
		return null;
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		Long id = getNextId();
		
		String sqlCreateAppointment = "INSERT INTO appointment(id, doctor_id, patient_id, start_date, end_date) VALUES (?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlCreateAppointment, id, appointment.getDoctorId(), appointment.getPatientId(), appointment.getStartDate(), appointment.getEndDate());
		
		if(rowsAffected == 1) {
			appointment.setId(id.intValue());
			return appointment;
		} else {
			return null;
		}
	}

	@Override
	public void updateAppointment(int appointmentId, int doctorId, int patientId, Date startDate, Date endDate) {
		jdbcTemplate.update("UPDATE appointment SET doctor_id = '"+doctorId+"' patient_id = '"+patientId+"' start_date = '"+startDate+"' end_date = '"+endDate+"' WHERE id = '"+appointmentId+"'");
	}

	@Override
	public void deleteAppointment(int appointmentId) {
		String sqlDeleteAppointment = "DELETE * FROM appointment WHERE id = ?";
		jdbcTemplate.update(sqlDeleteAppointment, appointmentId);
	}
	
	private Appointment mapToRowToAppointment (SqlRowSet row) {
		Appointment appointment = new Appointment();
		appointment.setId(row.getInt("id"));
		appointment.setDoctorId(row.getInt("doctor_id"));
		appointment.setPatientId(row.getInt("patient_id"));
		appointment.setStartDate(row.getTimestamp("start_date").toLocalDateTime());
		appointment.setEndDate(row.getTimestamp("end_date").toLocalDateTime());
		appointment.setMessage(row.getString("message"));
		return appointment;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('appointment_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next order id");
		}
	}
	
}
