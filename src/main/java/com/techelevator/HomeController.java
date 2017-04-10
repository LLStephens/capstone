package com.techelevator;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@RequestMapping(path="/offices", method=RequestMethod.GET)
	public String showOffice(@RequestParam String officeId, HttpServletRequest request) {
		List<Doctor> doctorList = doctorDAO.getAllDoctorsByOfficeId(officeId);
		request.setAttribute("doctorList", doctorList);
		return "offices";
	}
	
	@RequestMapping(path="/readReviews", method=RequestMethod.GET)
	public String showReviews(HttpServletRequest request) {
		Review review = reviewDAO.getAllSurveysByDoctorId();
		request.setAttribute("review", review);
		return "readReviews";
	}
	
	

	
}
