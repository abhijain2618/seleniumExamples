package com.techbodhi.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.RegistrationPageObjects;

public class PasswordTest {
	WebDriver driver;
	RegistrationPageObjects pageObjects;
	String strengthValue;

	@BeforeClass
	public void setUp() {
		SystemProp.getFireFoxProperty();
		driver = new FirefoxDriver();
		driver.get("http://demoqa.com/registration/");
		pageObjects = new RegistrationPageObjects();
	}

	@Test
	public void NoPasswordEntered() {
		WebElement strenthIndicator = pageObjects.findStrenghIndicator(driver);
		strengthValue = strenthIndicator.getText();
		if (strengthValue.equals("Strength Indicator"))
			System.out.println("test case passed");
		else
			System.out.println("test case failed");
	}

	@Test
	public void PasswordEntered_Error_Mismatch() {

		WebElement password = pageObjects.findPassword(driver);
		WebElement confirmPassword = pageObjects.findConfirmPassword(driver);
		WebElement strenthIndicator = pageObjects.findStrenghIndicator(driver);
		password.sendKeys("abcd123");
		confirmPassword.sendKeys("abcd123");
		strengthValue = strenthIndicator.getText();
		if (strengthValue.equals("Strength Indicator"))
			System.out.println("test case passed");
		else
			System.out.println("test case failed");
	}

	@AfterClass
	public void closeAll() {
		 driver.quit();
	}
}
