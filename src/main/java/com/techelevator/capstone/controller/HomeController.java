package com.techelevator.capstone.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;
import com.techelevator.capstone.dao.DoctorDAO;
import com.techelevator.capstone.dao.OfficeDAO;
import com.techelevator.capstone.dao.ReviewDAO;
import com.techelevator.capstone.model.Appointment;
import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.model.Office;
import com.techelevator.capstone.model.Review;


@Controller
@Scope("session")
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
	
	@RequestMapping(path="/offices", method=RequestMethod.GET)
	public String showOffice(@RequestParam int officeId, HttpServletRequest request) {
		List<Doctor> doctorList = doctorDAO.getAllDoctorsByOfficeId(officeId);
		request.setAttribute("doctorList", doctorList);
		String officeName = officeDAO.getOfficeById(officeId).getName();
	    request.setAttribute("officeName", officeName);
	    List<Review> reviewList = reviewDAO.getAllReviews();
		request.setAttribute("reviewList", reviewList);
		return "offices";
	}

	@RequestMapping(path="/readReviews", method=RequestMethod.GET)
	public String showReviews(@RequestParam int doctorId, HttpServletRequest request) {
		List<Review> reviewList = reviewDAO.getAllReviewsByDoctorId(doctorId);
		request.setAttribute("reviewList", reviewList);
		return "readReviews";
	}
	
	@RequestMapping(path="/writeReview", method=RequestMethod.GET)
	public String inputReview(@RequestParam int doctorId, HttpServletRequest request) {
		return "writeReview";
	}

	
	@RequestMapping(path="/writeReview", method=RequestMethod.POST)
	public String sendReview(Review review) {
		reviewDAO.addReview(review);
		return "redirect:/";
	}
	
	@RequestMapping(path="/doctorsAppointment", method=RequestMethod.GET)
	public String showDoctorsSelectedAppointment( HttpServletRequest request){
		
		return "/doctorsAppointment";
	}

	@RequestMapping("/calendar")
	public String showCalendar(HttpServletRequest request) {
		return "calendar";
	}
	

}
