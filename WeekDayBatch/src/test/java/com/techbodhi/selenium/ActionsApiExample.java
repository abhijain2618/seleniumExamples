package com.techbodhi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.techbodhi.core.SystemProp;

public class ActionsApiExample {

	public static void main(String[] args) {
		String baseUrl = "http://newtours.demoaut.com/";
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get(baseUrl);

		WebElement td_Home = driver
				.findElement(By
						.xpath("html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/p[2]/img"));

		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(
				driver.findElement(By.linkText("Home"))).build();

		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);
		mouseOverHome.perform();
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("After hover: " + bgColor);

		driver.findElement(By.linkText("SUPPORT")).click();

		Action moveToHomeOnSupportPage = builder.moveToElement(
				driver.findElement(By.linkText("Home"))).build();

		String bgColorSupportPage = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColorSupportPage);
		moveToHomeOnSupportPage.perform();
		bgColorSupportPage = td_Home.getCssValue("background-color");
		System.out.println("After hover: " + bgColorSupportPage);

		driver.close();
	}
}