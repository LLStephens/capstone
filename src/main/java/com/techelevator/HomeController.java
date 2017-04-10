package com.techelevator;


<<<<<<< HEAD

=======
>>>>>>> a8e6c438e49c5333bb984d31a450e80dcaa81adb
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;



@Controller
public class HomeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome(HttpServletRequest request) {
		List<Office> officeList = officeDAO.getAllOffices();
		request.setAttribute("officeList", officeList);
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
