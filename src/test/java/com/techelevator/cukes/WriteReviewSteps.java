package com.techelevator.cukes;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.OfficePage;

import cucumber.api.java.en.Given;

public class WriteReviewSteps {

	private WebDriver webDriver;
	private OfficePage officepage;
	private HomePage homePage;
	
	@Autowired
	public WriteReviewSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.officepage = new OfficePage(webDriver);
	}
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_home_page() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
	}
	
}
