package com.techbodhi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.techbodhi.core.SystemProp;

public class FileUploadExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = SystemProp.getDriver("firefox");
		String baseUrl = "http://demo.guru99.com/selenium/upload/";


		driver.get(baseUrl);
		  WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

	        // enter the file path onto the file-selection input field
	        uploadElement.sendKeys("C:\\newhtml.html");

	        // check the "I accept the terms of service" check box
	        driver.findElement(By.id("terms")).click();

	        // click the "UploadFile" button
	        driver.findElement(By.name("send")).click();
	        
	}
}
