package com.techbodhi.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techbodhi.selenium.core.SystemProp;

public class DragNDropNFrame {

	WebDriver driver ;
	@BeforeClass(alwaysRun=true)
	@Parameters("browserName")
	public void setUp(String browserName){
		driver = SystemProp.getDriver(browserName);		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void refreshPage(){
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@Test(groups={"end-to-end","regression"})
	public void dragNDropTest(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		Actions builder = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Action dragAndDrop = builder.dragAndDrop(source, target).build(); 
		dragAndDrop.perform();
	}
	

	

	
	@AfterClass(alwaysRun=true)
	public void closeAll(){
		driver.quit();
	}
	

	
	@Test
	public void dragNDropTestExampleTwo(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		Actions builder = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Action dragAndDrop = builder.clickAndHold(source).moveToElement(target).release().build();
		dragAndDrop.perform();
	}

}
