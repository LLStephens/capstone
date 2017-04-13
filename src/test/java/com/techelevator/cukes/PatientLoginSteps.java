package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.PatientLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PatientLoginSteps {

	private WebDriver webDriver;
	private PatientLoginPage patientLoginPage;
	private HomePage homePage;
	
	@Autowired
	public PatientLoginSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.patientLoginPage = new PatientLoginPage(webDriver);
	}
	
	@Given("^I am logging in as a patient$")
	public void i_am_logging_in_as_a_patient() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
		homePage.clickPatientLoginLink();
	}
	
	@Given("^I input a username of (.*)$")
	public void i_input_a_username(String userName) throws Throwable {
		patientLoginPage.enterUserName(userName);
	}
	
	@Given("I input a password of (.*)$")
	public void i_input_a_password(String password) throws Throwable {
		patientLoginPage.enterPassword(password);
	}
	
	@When("I login as a patient$")
	public void i_login_as_a_patient() throws Throwable {
		patientLoginPage.patientLogin();
	}
	
	@Then("I am back on the home page logged in$")
	public void i_am_back_on_the_home_page_logged_in() throws Throwable {
		String url = webDriver.getCurrentUrl();
		Assert.assertTrue(url.equals("http://localhost:8080/capstone/"));
	}
}
