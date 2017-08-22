package com.techbodhi.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.RegistrationPageObjects;

public class RegistrationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/registration/");
		RegistrationPageObjects pageObjects = new RegistrationPageObjects();

		WebElement firstName = pageObjects.findFirstName(driver);

		// WebElement lastName = pageObjects.findLastName(driver);
		// WebElement phoneNumber = pageObjects.findPhoneNumber(driver);
		// WebElement userName = pageObjects.findUserName(driver);
		// WebElement eMail = pageObjects.findEmail(driver);
		WebElement radioButton = pageObjects.findRadioButton(driver, 2);

		WebElement checkBox = pageObjects.findCheckBox(driver, 1);

		firstName.sendKeys("Abhishek");
		checkBox.click();
		radioButton.click();

		
		
		

	}

}
