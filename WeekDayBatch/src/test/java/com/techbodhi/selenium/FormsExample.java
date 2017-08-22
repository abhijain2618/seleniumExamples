package com.techbodhi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techbodhi.core.SystemProp;

public class FormsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// declaration and instantiation of objects/variables
		WebDriver driver = SystemProp.getDriver("firefox");

		//Create explicit wait.
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		
		
		String baseUrl = "http://newtours.demoaut.com/";
		driver.get(baseUrl);

		//wait until text box load.
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));

		// Enter value into textbox
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		
		String test = driver.findElement(By.name("test")).getAttribute("Value");
		// Delete value from textbox
		driver.findElement(By.name("userName")).clear();

		// Access Links
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.partialLinkText("SIGN-ON")).click();

		// Enter value into textbox and SUBMIT
		driver.findElement(By.name("userName")).sendKeys ("tutorial");
		driver.findElement(By.name("password")).sendKeys ("tutorial");
		driver.findElement(By.name("password")).submit();

		// Select Radio Button
		driver.findElement(By.cssSelector("input[value=Business]")).click();

		//Select CheckBox
		String baseURL = "http://demo.guru99.com/sele...";
		driver.get(baseURL);

		//Create an Explicit wait.
		WebDriverWait myWait2 = new WebDriverWait(driver, 10);
		myWait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("persist_box")));

		WebElement chkFBPersist = driver.findElement(By.id("persist_box"));
		for (int i=0; i<2; i++) {
			chkFBPersist.click (); 
			System.out.println(chkFBPersist.isSelected());
		}

	}

}
