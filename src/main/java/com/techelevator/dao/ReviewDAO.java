package com.techelevator.dao;

import java.util.List;

import com.techelevator.Review;

public interface ReviewDAO {
	public List<Review> getAllReviewsByDoctorId(int doctorId);
	public void updateReview(int reviewId);
	public void postReview(Review review);
	public void deleteReview(int reviewId);
}
