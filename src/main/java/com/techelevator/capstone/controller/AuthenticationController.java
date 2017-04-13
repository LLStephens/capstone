package com.techelevator.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.capstone.dao.PatientDAO;

@Controller
public class AuthenticationController {

	@Autowired
	private PatientDAO patientDao;
	
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam String userName, 
						@RequestParam String password,
						@RequestParam(required=false) String destination,
						ModelMap model) {
		if(patientDao.searchForUsernameAndPassword(userName, password)) {
			model.put("currentPatient", userName);
			if(destination != null) {
				return "redirect:/" + destination;
			} else {
				return "redirect:/users/"+userName;
			}
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
	
}
