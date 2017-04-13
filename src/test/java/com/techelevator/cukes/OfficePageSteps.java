package com.techelevator.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techelevator.pageobject.HomePage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@Component
public class OfficePageSteps {
		
	private WebDriver webDriver;
	private HomePage homePage;
			
	@Autowired
	public OfficePageSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage = new HomePage(webDriver);
	}
		
	@Given("^I am on the home page$")
	public void i_am_on_home_page() throws Throwable {
		webDriver.get("http://localhost:8080/capstone/");
	}
	
	@When("^I click on an office link$")
	public void i_click_on_an_office_link() throws Throwable {
		homePage.clickOfficeLink();
	}
	
	@Then("^I am taken to the office page$")
	public void i_am_taken_to_the_office_page() throws Throwable {
		String url = webDriver.getCurrentUrl();
		Assert.assertTrue(url.contains("officeId="));
		Assert.assertTrue(url.contains("offices"));
	}
}
