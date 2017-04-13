package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientRegistrationPage {
private WebDriver webDriver;
	
	public PatientRegistrationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public PatientRegistrationPage enterName(String name) {
		WebElement nameField = webDriver.findElement(By.name("name"));
		nameField.sendKeys(name);
		return this;
	}
	
	public PatientRegistrationPage enterDateOfBirth(String dateOfBirth) {
		WebElement dateOfBirthField = webDriver.findElement(By.name("date_of_birth"));
		dateOfBirthField.sendKeys(dateOfBirth);
		return this;
	}
	
	public PatientRegistrationPage enterAddress(String address) {
		WebElement addressField = webDriver.findElement(By.name("address"));
		addressField.sendKeys(address);
		return this;
	}
	
	public PatientRegistrationPage enterPhoneNumber(String phoneNumber) {
		WebElement phoneNumberField = webDriver.findElement(By.name("phone_number"));
		phoneNumberField.sendKeys(phoneNumber);
		return this;
	}
	
	public PatientRegistrationPage enterEmail(String email) {
		WebElement emailField = webDriver.findElement(By.name("email"));
		emailField.sendKeys(email);
		return this;
	}
	
	public PatientRegistrationPage enterUserName(String userName) {
		WebElement userNameField = webDriver.findElement(By.name("user_name"));
		userNameField.sendKeys(userName);
		return this;
	}
	
	public PatientRegistrationPage enterPassword(String password) {
		WebElement passwordField = webDriver.findElement(By.name("password"));
		passwordField.sendKeys(password);
		return this;
	}
	
	public PatientRegistrationPage enterConfirmPassword(String confirmPassword) {
		WebElement confirmPasswordField = webDriver.findElement(By.name("confirm_password"));
		confirmPasswordField.sendKeys(confirmPassword);
		return this;
	}
	
	public PatientLoginPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.id("patientRegisterButton"));
		submitButton.click();
		return new PatientLoginPage(webDriver);
	}
}
