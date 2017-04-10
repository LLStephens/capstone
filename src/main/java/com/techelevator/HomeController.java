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
	private OfficeDAO officeDao;
//	@Autowired
//	private DoctorDAO doctorDao;
//	@Autowired
//	private ReviewDAO reviewDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome(HttpServletRequest request) {
		List<Office> officeList = officeDao.getAllOffices();
		request.setAttribute("officeList", officeList);
		return "home";
	}

//	@RequestMapping(path="/offices", method=RequestMethod.GET)
//	public String showOffice(@RequestParam int officeId, HttpServletRequest request) {
//		List<Doctor> doctorList = doctorDao.getAllDoctorsByOfficeId(officeId);
//		request.setAttribute("doctorList", doctorList);
//		return "offices";
//	}
//	
//	@RequestMapping(path="/readReviews", method=RequestMethod.GET)
//	public String showReviews(@RequestParam int doctorId, HttpServletRequest request) {
//		List<Review> review = reviewDao.getAllReviewsByDoctorId(doctorId);
//		request.setAttribute("review", review);
//		return "readReviews";
//	}
//	
	

	
}
