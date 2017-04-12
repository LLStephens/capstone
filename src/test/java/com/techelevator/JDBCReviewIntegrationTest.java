package com.techelevator;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.DoctorDAO;
import com.techelevator.dao.JDBCDoctorDAO;
import com.techelevator.dao.JDBCReviewDAO;
import com.techelevator.dao.ReviewDAO;

public class JDBCReviewIntegrationTest extends DAOIntegrationTest {
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	
	private ReviewDAO reviewDAO;

	@Before
	public void setup(){
		reviewDAO = new JDBCReviewDAO(getDataSource());
	}
	
	@Test
	public void review_can_be_found_by_id_after_being_created(){
		Review review = new Review();
		review.setDoctorId(1);
		review.setRating(2);
		review.setMessage("message");
		Review newReview = reviewDAO.addReview(review);
		assert_reviews_are_equal(newReview, reviewDAO.getReviewById(newReview.getId()));
	}
	
	private void assert_reviews_are_equal(Review expectedReview, Review actualReview) {
		Assert.assertEquals (expectedReview.getId(), actualReview.getId());
		Assert.assertEquals(expectedReview.getRating(), actualReview.getRating());
		Assert.assertEquals(expectedReview.getDoctorId(), actualReview.getDoctorId());
		Assert.assertEquals(expectedReview.getMessage(), actualReview.getMessage());
		
	}
}
