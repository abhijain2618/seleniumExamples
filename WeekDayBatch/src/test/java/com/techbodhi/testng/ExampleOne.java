package com.techbodhi.testng;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleOne {

	WebDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		driver = new RemoteWebDriver(new URL("http://localhost/wd/hub"),
				capability);
		driver.get("http://demoqa.com/registration/");
	}

	@Test
	public void passwordValueTest() {
		String passwordText = null;
		passwordText = driver.findElement(By.id("piereg_passwordStrength"))
				.getText();
		assertEquals(passwordText, "Strength Indicator");
	}

	@Test
	public void passwordClass() {
		String classValue = null;
		classValue = driver.findElement(By.id("piereg_passwordStrength"))
				.getAttribute("class");
		assertEquals(classValue, "piereg_passwordksdfk");
	}

	@AfterClass
	public void quitAll() {
		// driver.quit();
	}

}
