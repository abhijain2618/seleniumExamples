package com.techbodhi.seleniumbasic.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {

	public WebElement findFirstName(WebDriver driver) {
		return driver.findElement(By.id("name_3_firstname"));
	}

	public WebElement findLastName(WebDriver driver) {
		WebElement lastName = driver.findElement(By.name("last_name"));
		return lastName;
	}

	public WebElement findPhoneNumber(WebDriver driver) {
		WebElement phoneNumber = driver
				.findElement(By
						.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[6]/div/input"));
		return phoneNumber;
	}

	public WebElement findEmail(WebDriver driver) {
		WebElement eMail = driver.findElement(By
				.className("piereg_validate[required,custom[email]]"));
		return eMail;
	}

	public WebElement findUserName(WebDriver driver) {
		WebElement userName = driver.findElement(By.cssSelector("#username"));
		return userName;
	}

	public WebElement findRadioButton(WebDriver driver, int radioButtonNumber) {
		WebElement radioButton = null;

		radioButton = driver
				.findElement(By
						.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[2]/div/div/input["
								+ radioButtonNumber + "]"));
		return radioButton;
	}

	public WebElement findCheckBox(WebDriver driver, int checkBoxNumber) {
		// TODO Auto-generated method stub
		WebElement radioButton = driver
				.findElement(By
						.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[3]/div/div/input["
								+ checkBoxNumber + "]"));
		return radioButton;
	}
	
	public WebElement findPassword(WebDriver driver){
		WebElement passwordField = driver.findElement(By.name("password"));
		return passwordField;
	}
	
	public WebElement findConfirmPassword(WebDriver driver){
		WebElement confirmPasswordField = driver.findElement(By.id("confirm_password_password_2"));
		return confirmPasswordField;
	}
	
	public WebElement findStrenghIndicator(WebDriver driver){
		WebElement strenghIndicator = driver.findElement(By.id("piereg_passwordStrength"));
		return strenghIndicator;
	}
	
	public WebElement findDropDown(WebDriver driver){
		WebElement dropDown = driver.findElement(By.id("dropdown_7"));
		return dropDown;
	}
	
	public WebElement findDropDownMonth(WebDriver driver){
		WebElement dropDown = driver.findElement(By.id("mm_date_8"));
		return dropDown;
	}
	public WebElement findDropDownDate(WebDriver driver){
		WebElement dropDown = driver.findElement(By.id("dd_date_8"));
		return dropDown;
	}
	public WebElement findDropDownYear(WebDriver driver){
		WebElement dropDown = driver.findElement(By.id("yy_date_8"));
		return dropDown;
	}
	

}
