package com.techbodhi.testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;




public class OnlyFrameExample {
	
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = SystemProp.getDriver("firefox");
		driver.get("http://demoqa.com/wp-content/themes/wp-knowledge-base/frame1.html");
	}
	
  @Test
  public void frameOnlyTest() {
	  String baseValue = "Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text. Demo text.";
		driver.switchTo().frame("topFrame");		
		String actualValue = driver.findElement(By.xpath("html/body/div[1]/p")).getText();
		assertEquals(actualValue, baseValue);
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
