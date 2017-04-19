package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoctorLoginPage {
private WebDriver webDriver;
	
	public DoctorLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public DoctorLoginPage enterUserName(String userName) {
		WebElement userNameField = webDriver.findElement(By.name("user_name"));
		userNameField.sendKeys(userName);
		return this;
	}
	
	public DoctorLoginPage enterPassword(String password) {
		WebElement passwordField = webDriver.findElement(By.name("password"));
		passwordField.sendKeys(password);
		return this;
	}
	
	public DoctorPortalPage doctorLogin() {
		WebElement loginButton = webDriver.findElement(By.id("login_button"));
		loginButton.submit();
		return new DoctorPortalPage(webDriver);
	}
}
