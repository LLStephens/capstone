package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.OfficePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReadReviewSteps {

	private WebDriver webDriver;
	private OfficePage officePage;
	private HomePage homePage;
	
	@Autowired
	public ReadReviewSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.officePage = new OfficePage(webDriver);
	}
	
	@Given("^I visit the home page$")
	public void i_am_on_home_page() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
	}
	
	@Given("^I click on an office page$")
	public void i_click_on_an_office_page() throws Throwable {
		homePage.clickOfficeLink();
	}
	
	@When("^I click on a read review link$")
	public void i_click_on_a_read_review_page() throws Throwable {
		officePage.clickReadReviewLink();
	}
	
	@Then("^I am taken to read a doctors reviews$")
	public void i_am_taken_to_read_doctors_reviews() throws Throwable {
		String url = webDriver.getCurrentUrl();
		Assert.assertTrue(url.contains("readReviews"));
		Assert.assertTrue(url.contains("doctorId"));
	}
}
