package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.OfficePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@Component
public class OfficePageSteps {
		
	private WebDriver webDriver;
	private HomePage homePage;
	private OfficePage officePage;
			
	@Autowired
	public OfficePageSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.officePage = new OfficePage(webDriver);
	}
		
	@Given("^I am on the home page$")
	public void i_am_on_home_page() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
	}
	
	@When("^I click on an office link$")
	public void i_click_on_an_office_link() throws Throwable {
		homePage.clickOfficeLink();
	}
	
	@Then("^the office name should be (.*)$")
	public void verifyOfficeName(String officeName) throws Throwable {
		officePage.verifyOfficeName(officeName);
		Assert.assertTrue(officePage.verifyOfficeName(officeName));
	}
	
	@Then("^the doctor name should be (.*)$")
	public void verifyDoctorName(String doctorName) throws Throwable {
		officePage.verifyDoctorName(doctorName);
		Assert.assertTrue(officePage.verifyDoctorName(doctorName));
	}
	
	@Then("^the doctor image should be (.*)$")
	public void verifyDoctorImage(String doctorImageName) throws Throwable {
		officePage.verifyDoctorImage(doctorImageName);
		Assert.assertTrue(officePage.verifyDoctorImage(doctorImageName));
	}
	
	@Then("^the doctor rating should be (.*)$")
	public void verifyDoctorRating(String doctorRating) throws Throwable {
		officePage.verifyDoctorRating(doctorRating);
		Assert.assertTrue(officePage.verifyDoctorRating(doctorRating));
	}
}
