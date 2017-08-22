package com.techbodhi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techbodhi.core.SystemProp;

public class AlertBoxEample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SystemProp.getDriver("firefox");

		driver.get("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();

		String alertMessage = driver.switchTo().alert().getText();

		System.out.println(alertMessage);

		driver.switchTo().alert().accept();

		driver.quit();
	}

}
