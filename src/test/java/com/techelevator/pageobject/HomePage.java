package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public OfficePage clickOfficeLink() {
		WebElement officeLink = webDriver.findElement(By.linkText("North Office"));
		officeLink.click();
		return new OfficePage(webDriver);
	}
	
	public PatientRegistrationPage clickPatientRegistrationLink(){
		logOut();
		WebElement patientRegistrationLink = webDriver.findElement(By.linkText("Register"));
		patientRegistrationLink.click();
		return new PatientRegistrationPage(webDriver);
	}
	
	public PatientLoginPage clickPatientLoginLink(){
		logOut();
		WebElement patientLoginLink = webDriver.findElement(By.linkText("Patient Login"));
		patientLoginLink.click();
		return new PatientLoginPage(webDriver);
	}
	
	public DoctorLoginPage clickDoctorLoginLink(){
		logOut();
		WebElement doctorLoginLink = webDriver.findElement(By.linkText("Provider Portal"));
		doctorLoginLink.click();
		return new DoctorLoginPage(webDriver);
	}
	
	private void logOut() {
		try {
			WebElement logoutLink = webDriver.findElement(By.id("logoutButton"));
			logoutLink.submit();
		} catch (NoSuchElementException e) {
	    }
	}
}
