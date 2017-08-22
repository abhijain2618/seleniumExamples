package com.techbodhi.testng;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;

public class FramesExample {

	WebDriver driver;
	String windowHandleParent;

	@BeforeClass
	public void beforeClass() {
		driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/");
		windowHandleParent = driver.getWindowHandle();
	}

	@Test
	public void frameSetExample_One() {
		driver.findElement(By.linkText("Frames and windows")).click();
		driver.findElement(
				By.xpath(".//a[contains(text(),'Frameset')][@id='ui-id-3']"))
				.click();
		driver.findElement(By.linkText("Open Frameset Window")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandleTemp : allWindowHandles) {
			if (!(windowHandleTemp.equalsIgnoreCase(windowHandleParent))) {
				driver.switchTo().window(windowHandleTemp);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("topFrame"));

		driver.switchTo().frame("topFrame");

		String textValue = driver.findElement(By.xpath("html/body/div[1]/p"))
				.getText();
		System.out.println(textValue);

	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}

}
