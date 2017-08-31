package com.techbodhi.testng;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.RegistrationPageObjects;

public class DropDownExample {
	WebDriver driver;
	RegistrationPageObjects pageObjects;
	String strengthValue;
	
	@BeforeClass(alwaysRun = true)
	public void setUp(){

		driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/registration/");
		pageObjects = new RegistrationPageObjects();
	}
	
	@Test (groups = { "regression" })
	public void checkDropDown_Index(){
	
		Select dropDown = new Select (pageObjects.findDropDown(driver));
		dropDown.selectByIndex(6);
	}
	
	@Test(groups = { "end-to-end" ,"regression"})
	public void checkDropDown_VisibleText(){
		Select dropDown = new Select(pageObjects.findDropDownDate(driver));
		dropDown.selectByVisibleText("23");
		List <WebElement> dropDownValues = dropDown.getOptions();
		driver.manage().window().maximize();
		for (WebElement webElement : dropDownValues) {
			System.out.println(webElement.getText());
		}
	}
	
	@Test(groups = { "end-to-end" ,"regression"})
	public void checkDropDown_Value(){
		Select dropDown = new Select(pageObjects.findDropDownYear(driver));
		dropDown.selectByValue("2006");
	}
	
	@Test (groups = { "end-to-end" ,"regression"})
	public void selectLastElementInDate(){
		Select dropDown = new Select(pageObjects.findDropDownDate(driver));
		selectDropDownByLastIndex(dropDown);
	}
	
	@Test (groups = { "regression" })
	public void selectLastElementInMonth(){
		Select dropDown = new Select(pageObjects.findDropDownMonth(driver));
		selectDropDownByLastIndex(dropDown);
	}
	
	public void selectDropDownByLastIndex(Select dropDown){
		List <WebElement> options = dropDown.getOptions();
		int sizeOfDropDown =  options.size();
		dropDown.selectByIndex(sizeOfDropDown-1);
	}
	
	@Test (groups = { "regression" })
	public void selectLastElementInMonthWebElement(){
		selectDropDownByLastIndexUsingWebElement(pageObjects.findDropDownMonth(driver));
	}
	
	public void selectDropDownByLastIndexUsingWebElement(WebElement webElement){
		Select dropDown = new Select(webElement);
		List <WebElement> options = dropDown.getOptions();
		int sizeOfDropDown =  options.size();
		dropDown.selectByIndex(sizeOfDropDown-1);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void closeAll(){
		driver.quit();
	}
}
