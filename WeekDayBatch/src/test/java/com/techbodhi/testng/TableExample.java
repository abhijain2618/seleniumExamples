package com.techbodhi.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;

public class TableExample {
	WebDriver driver;
	
  @Test(enabled=false)
  public void usingForLoop() {
	  for (int i = 1; i <= 5; i++) {
		  String xpath = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr["+ i +"]/td[1]";
		  System.out.println(driver.findElement(By.xpath(xpath)).getText());
	}
	  
  }
  @Test(enabled=false)
  public void usingArrayList(){
	  String xpath = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]";
	  List <WebElement>listOfElements = driver.findElements(By.xpath(xpath));
	  

	  for (WebElement webElement : listOfElements) {
		  System.out.println(webElement.getText());
	}
  }
  
  @Test
  public void usingArrayListForMultiple(){
	  String xpathLeftColumn = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td[1]";
	  String xpathRightColumn = "html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]";
	  List <WebElement>listOfElementsLeft = driver.findElements(By.xpath(xpathLeftColumn));
	  List <WebElement>listOfElementsRight = driver.findElements(By.xpath(xpathRightColumn));
	  
	  int count = listOfElementsLeft.size();
	  for (int i=0;i<count;i++){
		  System.out.print(listOfElementsLeft.get(i).getText());
		  System.out.print("\t\t\t");
		  System.out.println(listOfElementsRight.get(i).getText());
	  }
  }
  
  
	@BeforeClass
	public void beforeClass() {
		driver = SystemProp.getDriver("firefox");
		driver.get("http://newtours.demoaut.com/");
	}
	

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
