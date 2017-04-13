package com.techelevator.capstone.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.capstone.dao.ReviewDAO;
import com.techelevator.capstone.model.Review;

@RestController
public class ButtonController {
	
	@Autowired
	private ReviewDAO reviewDao;
	
	@RequestMapping(path="/api/review", method=RequestMethod.POST)
	public Review submitReview(@RequestBody Review review){
		reviewDao.addReview(review);
		return review;
	}
	
	@RequestMapping(path="/api/review", method=RequestMethod.GET)
	public List<Review> getReviews(@RequestParam int doctorId) {
		List<Review> reviewList = reviewDao.getAllReviewsByDoctorId(doctorId);
		return reviewList;
	}

}
