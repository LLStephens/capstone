package com.techelevator.capstone.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.capstone.dao.AppointmentDAO;
import com.techelevator.capstone.dao.DoctorDAO;
import com.techelevator.capstone.dao.OfficeDAO;
import com.techelevator.capstone.dao.ReviewDAO;
import com.techelevator.capstone.model.Appointment;
import com.techelevator.capstone.model.Doctor;
import com.techelevator.capstone.model.Review;
import com.techelevator.capstone.dao.PatientDAO;

@Controller
@Scope("session")
@SessionAttributes({"currentPatientId","currentDoctorId"})
public class AuthenticationController {
	
	private static final LocalTime eight = LocalTime.of(8, 00);
	private static final LocalTime eightThirty = LocalTime.of(8, 30);
	private static final LocalTime nine = LocalTime.of(9, 00);
	private static final LocalTime nineThirty = LocalTime.of(9, 30);
	private static final LocalTime ten = LocalTime.of(10, 00);
	private static final LocalTime tenThirty = LocalTime.of(10, 30);
	private static final LocalTime eleven = LocalTime.of(11, 00);
	private static final LocalTime elevenThirty = LocalTime.of(11, 30);
	private static final LocalTime noon = LocalTime.of(12, 00);
	private static final LocalTime noonThirty = LocalTime.of(12, 30);
	private static final LocalTime one = LocalTime.of(13, 00);
	private static final LocalTime oneThirty = LocalTime.of(13, 30);
	private static final LocalTime two = LocalTime.of(14, 00);
	private static final LocalTime twoThirty = LocalTime.of(14, 30);
	private static final LocalTime three = LocalTime.of(15, 00);
	private static final LocalTime threeThirty = LocalTime.of(15, 30);
	private static final LocalTime four = LocalTime.of(16, 00);
	private static final LocalTime fourThirty = LocalTime.of(16, 30);
	private LocalTime[] agenda = {eight, eightThirty, nine, nineThirty, ten, tenThirty, eleven, elevenThirty, noon, noonThirty, one, oneThirty, two, twoThirty, three, threeThirty, four, fourThirty};


	@Autowired
	private PatientDAO patientDao;
	@Autowired
	private	DoctorDAO doctorDao;
	@Autowired
	private	ReviewDAO reviewDao;
	@Autowired
	private	AppointmentDAO appointmentDao;

	
	
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
			//}s
			} else {
			return "redirect:/providerLogin";
			}
	}
	@RequestMapping(path="/providerView", method=RequestMethod.GET)
	public String displayProviderView(@DateTimeFormat(pattern="MM/dd/yyyy") @RequestParam(required=false) LocalDate date, ModelMap model, HttpServletRequest request) {
		Doctor doc = (Doctor) model.get("currentDoctorId");
		List<Review> drReviewList  = reviewDao.getAllReviewsByDoctorId(doc.getId());
		List<Appointment> allApptList = appointmentDao.getAllAppointmentsByDoctorId(doc.getId());
		List<LocalTime> apptTimes = new ArrayList<>();
		Map<LocalTime,Appointment> appointmentMap = new HashMap<LocalTime,Appointment>();
		
		List<Appointment> apptList = new ArrayList<>();
		
		if(date!=null){
			for(Appointment appt:allApptList){
				if(date.equals(appt.getStartDate().toLocalDate())){
					apptList.add(appt);
				}
			}
		} else{
			date = LocalDate.now();
			for(Appointment appt:allApptList){
				if(date.equals(appt.getStartDate().toLocalDate())){
					apptList.add(appt);
				}
			}
		}
		
		for(Appointment appt:apptList){
			LocalTime start = appt.getStartDate().toLocalTime();
			apptTimes.add(start);
			appointmentMap.put(start, appt);
		}
		
		Collections.sort(apptTimes);		
		request.setAttribute("map", appointmentMap);
		request.setAttribute("agenda", agenda);
		request.setAttribute("apptTimes", apptTimes);
		request.setAttribute("doctor", doc);
		request.setAttribute("review", drReviewList);
		return "providerView";
	}
		
	@RequestMapping(path="/providerView", method=RequestMethod.POST)
	public String updateFee(@RequestParam(required=false) String fee, @RequestParam int doctorId, HttpServletRequest request) {
		LocalDate newDate = null;
		if(fee!=null){
			doctorDao.updateDoctorFee(fee, doctorId);
		}
		return "redirect:/providerView";
	}
	
}
