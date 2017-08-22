package com.techbodhi.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationPageObjects {
	

	public WebElement getFirstName(WebDriver driver){
		WebElement firstName = driver.findElement(By.id("name_3_firstname"));
		return firstName;
	}
	public WebElement getLastName(WebDriver driver){
		WebElement lastName = driver.findElement(By.name("last_name"));
		return lastName;
	}
	public WebElement getCheckBox(WebDriver driver){
		WebElement checkBox = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[3]/div/div/input[1]"));
		return checkBox;
	}
	public WebElement getRadioButton(WebDriver driver){
		WebElement radioButton  = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[2]/div/div/input[1]"));
		return radioButton;
	}
	public WebElement getRadioButton(WebDriver driver, String value){
		WebElement radioButton  = driver.findElement(By.xpath(".//input[@value='" + value + "']"));
		return radioButton;
	}
	public WebElement getPassword(WebDriver driver){
		WebElement password = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[11]/div/input"));
		return password;
	}
	public WebElement getConfirmPassword(WebDriver driver){
		WebElement confirmPasswrod = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[12]/div/input"));
		return confirmPasswrod;
	}
	public WebElement getStrengthIndicator(WebDriver driver){
		WebElement strengthIndicator = driver.findElement(By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[13]/div/div"));
		return strengthIndicator;
	}
	public WebElement getDropDownCountry(WebDriver driver){
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown_7']"));
		return dropDown;
	}
	public WebElement getDropDownMonth(WebDriver driver){
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='mm_date_8']"));
		return dropDown;
	}
}
