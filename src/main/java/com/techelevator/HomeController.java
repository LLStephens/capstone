package com.techelevator;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.DoctorDAO;
import com.techelevator.dao.OfficeDAO;
import com.techelevator.dao.ReviewDAO;


@Controller
public class HomeController {
	@Autowired
	private OfficeDAO officeDAO;
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private ReviewDAO reviewDAO;
	
	@RequestMapping("/")
	public String showHome(HttpServletRequest request) {
		List<Office> officeList =officeDAO.getAllOffices();
		request.setAttribute("officeList", officeList);
		return "home";
	}
	
	//test method to show doctors on page (all doctors, not by officeId)
	@RequestMapping("/offices")
	public String showOffice(HttpServletRequest request) {
		List<Doctor> doctorList = doctorDAO.getAllDoctors();
		request.setAttribute("doctorList", doctorList);
		return "offices";
	}
	
	//test method for reviews
	@RequestMapping("/readReviews")
	public String showReviews(HttpServletRequest request) {
		List<Review> review = reviewDAO.getAllReviews();
		request.setAttribute("review", review);
		return "readReviews";
	}
	
	
	//Actual method to show doctors by officeId on office.jsp
//	@RequestMapping(path="/offices", method=RequestMethod.GET)
//	public String showOffice(@RequestParam int officeId, HttpServletRequest request) {
//		List<Doctor> doctorList = doctorDAO.getAllDoctorsByOfficeId(officeId);
//		request.setAttribute("doctorList", doctorList);
//		return "offices";
//	}
	
	//Actual method to show review by doctorId on office.jsp
//	@RequestMapping(path="/readReviews", method=RequestMethod.GET)
//	public String showReviews(@RequestParam int doctorId, HttpServletRequest request) {
//		List<Review> review = reviewDAO.getAllReviewsByDoctorId(doctorId);
//		request.setAttribute("review", review);
//		return "readReviews";
//	}
	
	

	
}
