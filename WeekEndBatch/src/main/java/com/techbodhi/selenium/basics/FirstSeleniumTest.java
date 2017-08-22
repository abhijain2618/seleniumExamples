package com.techbodhi.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.techbodhi.selenium.core.SystemProp;

public class FirstSeleniumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SystemProp systemProp = new SystemProp();
		SystemProp.getFireFoxProperties();
		WebDriver driver = new FirefoxDriver();

		driver.get("http://demoqa.com/registration/");
		
		//object identification and then Action
		//id
		WebElement firstName = driver.findElement(By.id("name_3_firstname"));
		firstName.sendKeys("Abhishek");

		//name
		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("Jain");
		
		//xpath 
		 WebElement radioButton = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[2]/div/div/input[1]"));
		 radioButton.click();

		 WebElement checkBox = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[3]/div/div/input[1]"));
		 checkBox.click();
		 

		 
		 WebElement strengthIndicator = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[13]/div/div"));
		 
		 System.out.println("Initial Text: " + strengthIndicator.getText());
		 System.out.println("id attribute: " + strengthIndicator.getAttribute("id"));
		 
		 WebElement password = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[11]/div/input"));
		 password.sendKeys("abcd");
		 
		 WebElement confirmPassword = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[12]/div/input"));
		 confirmPassword.sendKeys("abcd12"); 
		 
		 System.out.println("After Text: " + strengthIndicator.getText());
		 
		 
		 
		 
		 
	}

}
