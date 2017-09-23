package com.techbodhi.selenium.testng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.techbodhi.selenium.core.ScreenshotUtil;
import com.techbodhi.selenium.core.SystemProp;

public class TableElements {
	WebDriver driver;
  @Test (groups = { "regression" })
  public void readDataFromTable_Using_WebElement() throws IOException {
	  String xpathValue; 
	  
	  for (int i=1; i <=5;i++){
		  xpathValue = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[" + i + "]/td[1]";
		  System.out.println("readDataFromTable_Using_WebElement" + driver.findElement(By.xpath(xpathValue)).getText());
	  }
	  ScreenshotUtil.takeScreenShot(driver);
  }
  
  
  @Test(groups = { "end-to-end","regression" })
  public void readDataFromTable_Using_List(){
	  String xpathValue = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]"  ;
	  List<WebElement> listOfTableElements = driver.findElements(By.xpath(xpathValue));
	  for (WebElement webElement : listOfTableElements) {
		System.out.println("readDataFromTable_Using_List" + webElement.getText());
	}
  }
  
	@BeforeClass(alwaysRun=true)
	@Parameters("browserName")
	public void setUp(String browserName){
		driver = SystemProp.getDriver(browserName);	
		driver.get("http://newtours.demoaut.com/");
	}


  @AfterClass(alwaysRun=true)
  public void tearDown() {
	  driver.quit();
  }

}
