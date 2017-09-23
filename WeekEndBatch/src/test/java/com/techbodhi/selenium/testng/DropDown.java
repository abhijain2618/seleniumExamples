package com.techbodhi.selenium.testng;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techbodhi.selenium.core.SystemProp;
import com.techbodhi.selenium.pageObjects.RegistrationPageObjects;

public class DropDown {
	RegistrationPageObjects pageObjects;
	WebDriver driver;

	
	
	
	@BeforeClass(alwaysRun=true)
	@Parameters("browserName")
	public void setUp(String browserName){
		driver = SystemProp.getDriver(browserName);	
		driver.get("http://demoqa.com/registration/");
		pageObjects = new RegistrationPageObjects();
	}

	@Test(priority = 0 , groups = { "regression" })
	public void selectDropDownValue() {

		pageObjects.getFirstName(driver).sendKeys("Abhishek");

		Select dropDown = new Select(pageObjects.getDropDownCountry(driver));
		dropDown.selectByValue("Inalskddia");
		System.out.println(dropDown.getFirstSelectedOption().getText());

	}

	@Test(priority = 1,groups = { "end-to-end" })
	public void checkDropDownValues() {
		Select dropDown = new Select(pageObjects.getDropDownMonth(driver));

		List<WebElement> optionsValues = dropDown.getOptions();

		for (WebElement webElement : optionsValues) {
			System.out.println(webElement.getText());

		}
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
