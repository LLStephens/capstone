package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientLoginPage {
	
private WebDriver webDriver;
	
	public PatientLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public PatientLoginPage enterUserName(String userName) {
		WebElement userNameField = webDriver.findElement(By.name("user_name"));
		userNameField.sendKeys(userName);
		return this;
	}
	
	public PatientLoginPage enterPassword(String password) {
		WebElement passwordField = webDriver.findElement(By.name("password"));
		passwordField.sendKeys(password);
		return this;
	}
	
	public HomePage patientLogin() {
		WebElement loginButton = webDriver.findElement(By.id("login_button"));
		loginButton.submit();
		return new HomePage(webDriver);
	}
	
}
