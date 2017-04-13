package com.techelevator;

import java.util.List;

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

import com.techelevator.dao.DoctorDAO;
import com.techelevator.dao.PatientDAO;
import com.techelevator.dao.ReviewDAO;

@Controller
@Scope("session")
@SessionAttributes({"currentPatientId","currentDoctorId"})
public class AuthenticationController {

	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private	DoctorDAO doctorDao;
	@Autowired
	private	ReviewDAO reviewDao;
	
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String user_name, 
						@RequestParam String password,
						@RequestParam(required=false) String destination,
						ModelMap model) {
		if(patientDao.searchForUsernameAndPassword(user_name, password)) {
			model.put("currentPatientId", patientDao.getPatientById(patientDao.getIdByUsernameAndPassword(user_name, password)));
//			if(destination != null && destination != "login") {
//				return "redirect:/" + destination;
//			} else {
			return "redirect:/";
//			}
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String displayRegister() {
		return "register";
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String createUser(@RequestParam String name, @RequestParam String date_of_birth,@RequestParam String address,@RequestParam String phone_number,@RequestParam String email,@RequestParam String user_name,@RequestParam String password) {
		patientDao.savePatient(name, date_of_birth, address, phone_number, email, user_name, password);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		session.invalidate();
		model.remove("currentPatientId");
		model.remove("currentDoctorId");
		return "redirect:/";
	}
	
	@RequestMapping(path="/providerLogin", method=RequestMethod.GET)
	public String displyProviderLogin() {
		return "providerLogin";
	}
	
	@RequestMapping(path="/providerLogin", method=RequestMethod.POST)
	public String ProviderLogin(@RequestParam String user_name, 
			@RequestParam String password,
			@RequestParam(required=false) String destination,
			ModelMap model) {
			if(doctorDao.searchDoctorForUsernameAndPassword(user_name, password)) {
			model.put("currentDoctorId", doctorDao.getDoctorById(doctorDao.getDoctorIdByUsernameAndPassword(user_name, password)));
			//if(destination != null && destination != "login") {
			//	return "redirect:/" + destination;
			//} else {
			return "redirect:/providerView";
			//}
			} else {
			return "redirect:/providerLogin";
			}
	}
	@RequestMapping(path="/providerView", method=RequestMethod.GET)
	public String displyProviderView(ModelMap model, HttpServletRequest request) {
		Doctor doc = (Doctor) model.get("currentDoctorId");
		List<Review> drReviewList  = reviewDao.getAllReviewsByDoctorId(doc.getId());
		request.setAttribute("doctor", doc);
		request.setAttribute("review", drReviewList);
		return "providerView";
	}
	
	
	
	
}
