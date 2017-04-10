package com.techelevator.dao;

import java.util.List;

import com.techelevator.Review;

public interface ReviewDAO {
	public List<Review> getAllReviewsByDoctorId(int doctorId);
	public void updateReview(int rating, int doctorId, String message);
	public void deleteReview(int reviewId);
	public void addReview(Review review);
	public Review getReviewById(int id);
	public List<Review> getAllReviews();
}
