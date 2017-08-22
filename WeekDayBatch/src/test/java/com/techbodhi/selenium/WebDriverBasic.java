package com.techbodhi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techbodhi.core.SystemProp;

public class WebDriverBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/");
		// get page title and validate value 
		String pageTitle = driver.getTitle();
		
		System.out.println(pageTitle);
		if (pageTitle.equals("Demoqa | Just another WordPress site")){
			System.out.println("Test Case Passed");
		}else{
			System.out.println("test case failed");
		}
		// Selecting a link 
		driver.findElement(By.linkText("Registration")).click();
		
		driver.get("");
		
		driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
		// Entering value in text box
		driver.findElement(By.id("name_3_firstname")).sendKeys("First Name");
		
		driver.findElement(By.name("last_name")).sendKeys("Last Name");
		// Selecting radio button
		driver.findElement(By.xpath(".//*[@id='pie_register']/li[2]/div/div/input[1]")).click();
		// check if a check box is selected and printing value 
		
		driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div[1]/input[1]")).click();
		
		Boolean value = driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div[1]/input[1]")).isSelected();
		
		System.out.println(value);
				
		driver.quit();
		
		}

}
