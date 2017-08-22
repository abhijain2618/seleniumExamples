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

public class NewWindowExample {
	WebDriver driver;
	String windowHandleParent;
	
	
  @BeforeClass
  public void beforeClass() {
	  driver = SystemProp.getDriver("firefox");
	  driver.get("http://www.seleniumframework.com/Practiceform/");
	  windowHandleParent = driver.getWindowHandle();
  }
  
  
  @Test
  public void multipleTabWindowTest(){
	  driver.findElement(By.xpath(".//*[@id='button1']")).click();
	  Set<String> allWindowHandles = driver.getWindowHandles(); 	  
	  
	  for (String windowHandleTemp : allWindowHandles) {
		if(!(windowHandleTemp.equalsIgnoreCase(windowHandleParent))){
			driver.switchTo().window(windowHandleTemp);
		}
	}	  
	  driver.manage().window().maximize();
	  WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/h2/span/strong")));
	  
	  
	  
	  String value = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/h2/span/strong")).getText();
	  System.out.println(value);
  }
  
  
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
