package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.PatientRegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PatientRegistrationSteps {

	private WebDriver webDriver;
	private PatientRegistrationPage patientRegistrationPage;
	private HomePage homePage;
	
	@Autowired 
	public PatientRegistrationSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
		this.patientRegistrationPage = new PatientRegistrationPage(webDriver);
	}
	
	@Given("^I am registering as a new patient$")
	public void i_am_registering_as_a_new_patient() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
		homePage.clickPatientRegistrationLink();
	}
	
	@Given("^I enter a name of (.*)$")
	public void i_enter_a_name(String name) throws Throwable {
		patientRegistrationPage.enterName(name);
	}
	
	@Given("^I enter a date of birth of (.*)$")
	public void i_enter_a_date_of_birth(String dateOfBirth) throws Throwable {
		patientRegistrationPage.enterDateOfBirth(dateOfBirth);
	}
	
	@Given("^I enter an address of (.*)$")
	public void i_enter_an_address(String address) throws Throwable {
		patientRegistrationPage.enterAddress(address);
	}
	
	@Given("^I enter a phone number of (.*)$")
	public void i_enter_a_phone_number(String phoneNumber) throws Throwable {
		patientRegistrationPage.enterPhoneNumber(phoneNumber);
	}
	
	@Given("^I enter an email of (.*)$")
	public void i_enter_an_email(String email) throws Throwable {
		patientRegistrationPage.enterEmail(email);
	}
	
	@Given("^I enter a user name of (.*)$")
	public void i_enter_a_user_name(String userName) throws Throwable {
		patientRegistrationPage.enterUserName(userName);
	}
	
	@Given("^I enter a password of (.*)$")
	public void i_enter_a_password(String password) throws Throwable {
		patientRegistrationPage.enterPassword(password);
	}
	
	@Given("^I confirm the password with (.*)$")
	public void i_confrim_the_password(String confirmPassword) throws Throwable {
		patientRegistrationPage.enterConfirmPassword(confirmPassword);
	}
	
	@When("^I create a user$")
	public void i_create_a_user() throws Throwable {
		patientRegistrationPage.submitForm();
	}
	
	@Then("^I am directed to the login page$")
	public void i_am_directed_to_the_login_page() throws Throwable {
		String url = webDriver.getCurrentUrl();
		Assert.assertTrue(url.contains("login"));
		Assert.assertNotNull(webDriver.findElement(By.className("loginBox")));
	}
	
	
}
