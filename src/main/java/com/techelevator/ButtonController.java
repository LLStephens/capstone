package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ReviewDAO;

@RestController
public class ButtonController {
	
	@Autowired
	private ReviewDAO reviewDao;
	
	@RequestMapping(path="/api/review", method=RequestMethod.POST)
	public Review submitReview(@RequestBody Review review){
		System.out.println("received woohoo");
		
		reviewDao.addReview(review);
		
		return review;
	}

}
