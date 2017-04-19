package com.techelevator.capstone.dao;

import java.util.List;

import com.techelevator.capstone.model.Review;

public interface ReviewDAO {
	public List<Review> getAllReviewsByDoctorId(long id);
	public void updateReview(int rating, int doctorId, String message);
	public void deleteReview(int reviewId);
	public Review addReview(Review review);
	public Review getReviewById(int id);
	public List<Review> getReviewsByPatientId(int patientId);
	public List<Review> getAllReviews();
	public Review addReviewResponse(int reviewId, String response);
}
