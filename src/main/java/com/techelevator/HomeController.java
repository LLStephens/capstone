package com.techelevator;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;



@Controller
public class HomeController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHome(HttpServletRequest request) {
		List<Office> officeList = officeDAO.getAllOffices();
		request.setAttribute("officeList", officeList);
		return "home";
	}

	@RequestMapping("/offices")
	public String showOffices() {
		return "offices";
	}
	
}
