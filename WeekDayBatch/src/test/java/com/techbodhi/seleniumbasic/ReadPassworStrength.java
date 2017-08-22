package com.techbodhi.seleniumbasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.RegistrationPageObjects;

public class ReadPassworStrength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/registration/");
 
		RegistrationPageObjects pageObjects = new RegistrationPageObjects();
		String strengthValue;
		
		
		WebElement password = pageObjects.findPassword(driver);
		WebElement confirmPassword = pageObjects.findConfirmPassword(driver);
		WebElement strenthIndicator = pageObjects.findStrenghIndicator(driver);

			//no value 
		strengthValue = strenthIndicator.getText();
		System.out.println(strengthValue);
		
		if (strengthValue.equals("Strength Indicator"))
			System.out.println("test case passed");
		else 
			System.out.println("test case failed");
		
			//enter password 
		password.sendKeys("abcd123");
		confirmPassword.sendKeys("abcd123");
		

		strengthValue = strenthIndicator.getText();
		System.out.println(strengthValue);
		
		if (strengthValue.equals("Strength Indicator"))
			System.out.println("test case passed");
		else 
			System.out.println("test case failed");
		
		
		
	}

}
