package com.techbodhi.selenium.testng;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.techbodhi.selenium.core.SystemProp;
import com.techbodhi.selenium.pageObjects.RegistrationPageObjects;

public class DropDown {
	RegistrationPageObjects pageObjects;
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  SystemProp.getFireFoxProperties();
	  driver = new FirefoxDriver();
	  pageObjects = new RegistrationPageObjects();
	  driver.get("http://demoqa.com/registration/");
  }
  
  @Test(priority=0)
  public void selectDropDownValue() {
	  
	  pageObjects.getFirstName(driver).sendKeys("Abhishek");
	  
	  Select dropDown = new Select(pageObjects.getDropDownCountry(driver));
	  dropDown.selectByValue("India");
	  System.out.println(dropDown.getFirstSelectedOption().getText());
	  
  }
  
  @Test(priority=1)
  public void checkDropDownValues(){
	  Select dropDown = new Select(pageObjects.getDropDownMonth(driver));
	 
	  List<WebElement> optionsValues = dropDown.getOptions();
	  
	  for (WebElement webElement : optionsValues) {
		  System.out.println(webElement.getText());
		
	}
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
