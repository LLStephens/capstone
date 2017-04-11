package com.techelevator;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping(path="/offices", method=RequestMethod.GET)
	public String showOffice(@RequestParam int officeId, HttpServletRequest request) {
		List<Doctor> doctorList = doctorDAO.getAllDoctorsByOfficeId(officeId);
		request.setAttribute("doctorList", doctorList);
		String officeName = officeDAO.getOfficeById(officeId).getName();
	    request.setAttribute("officeName", officeName);
		return "offices";
	}
	
	@RequestMapping(path="/readReviews", method=RequestMethod.GET)
	public String showReviews(@RequestParam int doctorId, HttpServletRequest request) {
		List<Review> review = reviewDAO.getAllReviewsByDoctorId(doctorId);
		request.setAttribute("review", review);
		return "readReviews";
	}
	
	@RequestMapping(path="/writeReview", method=RequestMethod.GET)
	public String inputReview() {
		return "writeReview";
	}
	
	
}
