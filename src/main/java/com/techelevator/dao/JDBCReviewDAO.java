package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Office;
import com.techelevator.Review;

@Component
public class JDBCReviewDAO implements ReviewDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCReviewDAO (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Review> getAllReviews() {
		List<Review> allReviews = new ArrayList<>();
		String sqlSelectAllReviews = "SELECT * FROM review";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews);
		while(results.next()) {
			allReviews.add(mapToRowToReview(results));
		}
		return allReviews;
	}
	
	@Override
	public List<Review> getAllReviewsByDoctorId(int doctorId) {
		List<Review> allReviewsForDoctor = new ArrayList<>();
		String sqlSelectAllReviewsForDoctor = "SELECT * FROM review WHERE doctor_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviewsForDoctor, doctorId);
		while(results.next()) {
			allReviewsForDoctor.add(mapToRowToReview(results));
		}
		return allReviewsForDoctor;
	}

	@Override
	public Review getReviewById(int id) {
		String sqlSelectReviewById = "SELECT * FROM review WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectReviewById, id);
		while(results.next()) {
			 return mapToRowToReview(results);
		}
		return null;
	}

	@Override
	public Review addReview(Review review) {
		Long id = getNextId();
		
		String sqlInsertReview = "INSERT INTO review(id, rating, doctor_id, message) VALUES (?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(sqlInsertReview, id, review.getRating(), review.getDoctorId(), review.getMessage());
		
		if(rowsAffected == 1) {
			review.setId(id.intValue());
			return review;
		} else {
			return null;
		}
	}
	
	@Override
	public void updateReview(int rating, int doctorId, String message) {
		jdbcTemplate.update("UPDATE review SET address = '"+rating+"' doctor_id = '"+doctorId+"' message = '"+message+"'");
	}

	@Override
	public void deleteReview(int id) {
		String sqlDeleteReview = "DELETE * FROM review WHERE id = ?";
		jdbcTemplate.update(sqlDeleteReview, id);
	}
	private Review mapToRowToReview (SqlRowSet row) {
		Review review = new Review();
		review.setId(row.getInt("id"));
		review.setRating(row.getInt("rating"));
		review.setDoctorId(row.getInt("doctor_id"));
		review.setMessage(row.getString("message"));
		return review;
	}
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('review_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next order id");
		}
	}
	
}
