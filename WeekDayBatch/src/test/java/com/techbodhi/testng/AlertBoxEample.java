package com.techbodhi.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;

public class AlertBoxEample {

	/**
	 * @param args
	 */
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = SystemProp.getDriver("firefox");
	}

	@Test
	public void validateAlertMessage() {
		driver.get("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
	}

	@AfterClass
	public void closeAll() {
		driver.quit();
	}

}
