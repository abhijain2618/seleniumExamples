package com.techbodhi.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.RegistrationPageObjects;

public class DragAndDrop {
	WebDriver driver;
	RegistrationPageObjects pageObjects;
	String strengthValue;

	@BeforeClass
	public void setUp() {
		driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/registration/");
		pageObjects = new RegistrationPageObjects();
	}

	@AfterClass
	public void closeAll() {
		driver.quit();
	}
}
