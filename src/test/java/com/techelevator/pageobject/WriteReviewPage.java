package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WriteReviewPage {

	private WebDriver webDriver;
	
	public WriteReviewPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WriteReviewPage enterComment(String comment) {
		WebElement commentField = webDriver.findElement(By.name("message"));
		commentField.sendKeys(comment);
		return this;
	}
	
	public WriteReviewPage selectRating(String rating) {
		Select reviewRating = new Select(webDriver.findElement(By.id("starRating")));
		reviewRating.selectByVisibleText(rating);
		return this;
	}
}
