package com.techelevator.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.Appointment;

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
	public void createAppointment(Appointment appointment) {
		String sqlCreateAppointment = "INSERT INTO appointment(doctor_id, patient_id, start_date, end_date) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlCreateAppointment, appointment.getDoctorId(), appointment.getPatientId(), appointment.getStartDate(), appointment.getEndDate());
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
		appointment.setStartDate(row.getDate("start_date"));
		appointment.setEndDate(row.getDate("end_date"));
		return appointment;
	}
	
}
