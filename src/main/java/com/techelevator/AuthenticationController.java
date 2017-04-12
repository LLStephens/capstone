package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.dao.PatientDAO;

@Controller
@Scope("session")
@SessionAttributes("currentPatientId")
public class AuthenticationController {

	@Autowired
	private PatientDAO patientDao;
	
	
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
			return "redirect:/";
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
//		session.removeAttribute("currentPatientId");
		return "redirect:/";
	}
	
}
