package com.techelevator.capstone.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;
import com.techelevator.capstone.dao.AppointmentDAO;
import com.techelevator.capstone.dao.DoctorDAO;
import com.techelevator.capstone.dao.OfficeDAO;
import com.techelevator.capstone.dao.ReviewDAO;
import com.techelevator.capstone.model.Appointment;
import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.model.Office;
import com.techelevator.capstone.model.Patient;
import com.techelevator.capstone.model.Review;


@Controller
@Scope("session")
@SessionAttributes({"currentPatientId","currentPatientId2","currentDoctorId","currentDoctorId2"})
public class HomeController { 
	@Autowired
	private OfficeDAO officeDAO;
	@Autowired
	private DoctorDAO doctorDAO;
	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private AppointmentDAO appointmentDAO;

	@RequestMapping("/")
	public String showHome(HttpServletRequest request, ModelMap model,  HttpSession session) {
		List<Office> officeList =officeDAO.getAllOffices();
		request.setAttribute("officeList", officeList);
		
		if(model.get("currentDoctorId") != null ){
			model.remove("currentDoctorId");
			model.remove("currentDoctorId2");	
			session.invalidate();
		}
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
	public String inputReview(@RequestParam int doctorId, ModelMap model, HttpServletRequest request) {

		if(model.get("currentPatientId") == null ){
			request.setAttribute("patientId",-1);
		}else{
			Patient tempPatient = (Patient) model.get("currentPatientId");
			request.setAttribute("patientId", tempPatient.getId());
		}
		return "writeReview";
	}

	
	@RequestMapping(path="/writeReview", method=RequestMethod.POST)
	public String sendReview(Review review) {
		reviewDAO.addReview(review);
		return "redirect:/";
	}

	@RequestMapping(path="/updateReview", method=RequestMethod.GET)
	public String respondToReview(@RequestParam int doctorId, @RequestParam int reviewId, HttpServletRequest request) {
		return "updateReview";
	}

	
	@RequestMapping(path="/updateReview", method=RequestMethod.POST)
	public String updatedReview(@RequestParam String response, @RequestParam int reviewId, HttpServletRequest request, ModelMap model, HttpSession session) {
		reviewDAO.addReviewResponse(reviewId, response);
		
		if(model.get("currentDoctorId") != null ){
//			model.remove("currentDoctorId");
//			model.remove("currentDoctorId2");	
//			session.invalidate();
			return "redirect:/providerView";
			
		}
		return "home";
		
	}
	
	

	@RequestMapping(path="/changePassword", method=RequestMethod.GET)
	public String changePassword(@RequestParam int doctorId, HttpServletRequest request) {
		return "changePassword";
	}
	
	@RequestMapping(path="/changePassword", method=RequestMethod.POST)
	public String changePassword(@RequestParam String password, @RequestParam int doctorId) {
		doctorDAO.updateDoctorPassword(password, doctorId);
		return "redirect:/";
	}
	
	@RequestMapping(path="/topDoctors", method=RequestMethod.GET)
	public String displayTopDoctors(HttpServletRequest request){
//		List<Doctor> doctorsList = new ArrayList<>();
//		doctorsList = doctorDAO.getAllDoctors();
//		
//		
//		List<Review> reviewsList = new ArrayList<>();
//		for(Doctor doc:doctorsList){
//			reviewsList = reviewDAO.getAllReviewsByDoctorId(doc.getId());
//			
//		}
//	
//		
		
		return "topDoctors";
	}

}
