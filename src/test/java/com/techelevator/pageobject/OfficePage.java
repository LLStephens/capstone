package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficePage {
	private WebDriver webDriver;
	
	public OfficePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public ReadReviewPage clickReadReviewLink() {
		WebElement readReviewLink = webDriver.findElement(By.id("readReviewButton"));
		readReviewLink.click();
		return new ReadReviewPage(webDriver);
	}
	
	public WriteReviewPage clickWriteReviewLink() {
		WebElement writeReviewLink = webDriver.findElement(By.id("writeReviewButton"));
		writeReviewLink.click();
		return new WriteReviewPage(webDriver);
	}
	
	
	
	
//	public boolean verifyOfficeName(String officeName) {
//		WebElement outputOfficeName = webDriver.findElement(By.id("officeName"));
//		return outputOfficeName.getText().equals(officeName);
//	}
//	
//	public boolean verifyDoctorName(String doctorName) {
//		WebElement outputDoctorName = webDriver.findElement(By.id("doctorName"));
//		return outputDoctorName.getText().equals(doctorName);
//	}
//	
//	public boolean verifyDoctorImage(String doctorImageName) {
//		WebElement outputDoctorImageName = webDriver.findElement(By.id("doctorImg"));
//		return outputDoctorImageName.getText().equals(doctorImageName);
//	}
//	
//	public boolean verifyDoctorRating(String doctorRating) {
//		WebElement outputDoctorRating = webDriver.findElement(By.id("doctorRating"));
//		return outputDoctorRating.toString().equals(doctorRating);
//	}
}
