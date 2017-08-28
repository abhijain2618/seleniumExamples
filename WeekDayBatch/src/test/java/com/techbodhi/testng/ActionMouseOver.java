package com.techbodhi.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;

public class ActionMouseOver {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = SystemProp.getDriver("firefox");
		
	}

	@Test (enabled=false)
	public void clickOnMenuItem_iPhone() {
		driver.get("http://store.demoqa.com/");
		WebElement element = driver
				.findElement(By.linkText("Product Category"));
		Actions action = new Actions(driver);
		
		Action mouseOver = action.moveToElement(element).build();
		for(int i = 1 ; i<=6; i++){
		mouseOver.perform();
		
		System.out.println(driver.findElement(By.xpath("html/body/div[2]/div/div/header/nav/ul/li[2]/ul/li["+ i +"]/a")).getText());
		}
		

	}
	
	@Test (enabled=false)
	public void checkDemoAutSite(){
		driver.get("http://newtours.demoaut.com/index.php");
		Actions builder = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]"));
		WebElement checkElement = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[1]"));
				
		Action mouseOver = builder.moveToElement(target).build();
		System.out.println("Before Mouse Over" + checkElement.getAttribute("background"));
		mouseOver.perform();
		
		
		System.out.println("After Mouse Over" + checkElement.getAttribute("background"));
		
	}
	
	@Test
	public void checkStoreSite(){
		driver.get("http://store.demoqa.com/");
		Actions builder = new Actions(driver);
		
		 WebElement myaccount = driver.findElement(By.xpath("html/body/div[2]/div/div/header/div[2]/a/span[1]"));
		
		 System.out.println("Before Margin Value: " + myaccount.getCssValue("margin-top"));
				
		Action mouseOver = builder.moveToElement(myaccount).build();
		mouseOver.perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		System.out.println("After Margin Value: " + myaccount.getCssValue("margin-top"));
		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
