package com.techbodhi.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.techbodhi.selenium.core.SystemProp;
import com.techbodhi.selenium.pageObjects.RegistrationPageObjects;

public class FillRegistrationPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pre-requisites
		RegistrationPageObjects pageObjects = new RegistrationPageObjects();
		SystemProp.getFireFoxProperties();
		WebDriver driver = new FirefoxDriver();
		
		//Test case
		driver.get("http://demoqa.com/registration/");
		System.out.println("Before: " + pageObjects.getStrengthIndicator(driver).getText());
		pageObjects.getPassword(driver).sendKeys("abcd123");
		pageObjects.getConfirmPassword(driver).sendKeys("abcd123");
		System.out.println("After: " + pageObjects.getStrengthIndicator(driver).getText());
		
		//post 
		//driver.quit();
	}

}
