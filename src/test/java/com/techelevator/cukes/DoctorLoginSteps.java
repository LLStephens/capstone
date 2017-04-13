package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.pageobject.DoctorLoginPage;
import com.techelevator.pageobject.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DoctorLoginSteps {

	private WebDriver webDriver;
	private DoctorLoginPage doctorLoginPage;
	private HomePage homePage;
	
	@Autowired
	public DoctorLoginSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.doctorLoginPage = new DoctorLoginPage(webDriver);
	}
	
	@Given("^I am logging in as a doctor$")
	public void i_am_logging_in_as_a_doctor() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
		homePage.clickDoctorLoginLink();
	}
	
	@Given("^I input a doctor username of (.*)$")
	public void i_input_a_doctor_username(String userName) throws Throwable {
		doctorLoginPage.enterUserName(userName);
	}
	
	@Given("^I input a doctor password of (.*)$")
	public void i_input_a_doctor_password(String password) throws Throwable {
		doctorLoginPage.enterPassword(password);
	}
	
	@When("^I login as a doctor$")
	public void i_login_as_a_doctor() throws Throwable {
		doctorLoginPage.doctorLogin();
	}
	
	@Then("^I am transferred to the doctor portal$")
	public void i_am_at_the_doctor_portal() throws Throwable {
		String url = webDriver.getCurrentUrl();
		Assert.assertTrue(url.contains("providerView"));
	}
}
