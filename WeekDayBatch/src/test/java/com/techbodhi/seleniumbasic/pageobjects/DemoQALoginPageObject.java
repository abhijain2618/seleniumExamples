package com.techbodhi.seleniumbasic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQALoginPageObject {

	public WebElement getUsernameField(WebDriver driver) {
		return driver.findElement(By.id("log"));
	}

	public WebElement getPasswordField(WebDriver driver) {
		return driver.findElement(By.id("pwd"));
	}

	public WebElement getLoginbutton(WebDriver driver) {
		return driver.findElement(By.id("login"));
	}

}
