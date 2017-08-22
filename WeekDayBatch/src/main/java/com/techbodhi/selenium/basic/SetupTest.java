package com.techbodhi.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demoqa.com/");
		WebElement registrationLink = driver.findElement(By.linkText("Registration"));
		registrationLink.click();
		
		WebElement firstNamebyId = driver.findElement(By.id("name_3_firstname"));
		
		WebElement firstNamebyName = driver.findElement(By.name("first_name"));
		
		
		WebElement firstNamebyCss = driver.findElement(By.cssSelector("#name_3_firstname"));
		
		WebElement firstNamebyXpathAbs = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[1]/div[1]/input"));
		
		WebElement firstNamebyXpathRelative = driver.findElement(By.xpath("//input[@name='first_name']"));
		
		
		
		
		WebElement lastName = driver.findElement(By.id("name_3_lastname"));
		WebElement phoneNumber = driver.findElement(By.id("phone_9"));
		
		driver.findElement(By.id("name_3_firstname")).sendKeys("Abhishek");
		lastName.sendKeys("jain");
		phoneNumber.sendKeys("1234345");
		
		
		
		
		
		//driver.quit();
	}

}
