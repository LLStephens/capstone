package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@RequestMapping(path="/officeDetail", method=RequestMethod.GET)
	public String displayOfficeDetail(HttpServletRequest request) {

		return "officeDetails";
	}
}
