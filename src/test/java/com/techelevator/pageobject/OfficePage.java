package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficePage {
	private WebDriver webDriver;
	
	public OfficePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public boolean verifyOfficeName(String officeName) {
		WebElement outputOfficeName = webDriver.findElement(By.id("officeName"));
		return outputOfficeName.getText().equals(officeName);
	}
	
	public boolean verifyDoctorName(String doctorName) {
		WebElement outputDoctorName = webDriver.findElement(arg0)
	}
}
