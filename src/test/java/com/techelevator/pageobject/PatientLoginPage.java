package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientLoginPage {
	
private WebDriver webDriver;
	
	public PatientLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public PatientLoginPage enterName(String name) {
		WebElement nameField = webDriver.findElement(By.name("name"));
		nameField.sendKeys(name);
		return this;
	}
}
