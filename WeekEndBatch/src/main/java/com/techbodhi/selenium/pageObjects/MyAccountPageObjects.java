package com.techbodhi.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPageObjects {

	public WebElement getUserName(WebDriver driver){
		WebElement userName = driver.findElement(By.xpath(".//*[@id='log']"));
		return userName;
	}
	
	public WebElement getPassword(WebDriver driver){
		WebElement password = driver.findElement(By.xpath(".//*[@id='pwd']"));
		return password;
	}
	
	public WebElement getLoginButton(WebDriver driver){
		WebElement loginButton = driver.findElement(By.xpath(".//*[@id='login']"));
		return loginButton;
	}
	public WebElement getErrorMessage(WebDriver driver){
		WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='ajax_loginform']/p[1]"));
		return errorMessage;
	}

}
