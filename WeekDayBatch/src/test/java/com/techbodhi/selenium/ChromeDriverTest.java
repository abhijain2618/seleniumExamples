package com.techbodhi.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techbodhi.core.SystemProp;

public class ChromeDriverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SystemProp.getDriver("chrome");
		
		driver.get("http://newtours.demoaut.com/");
		
	}

}
