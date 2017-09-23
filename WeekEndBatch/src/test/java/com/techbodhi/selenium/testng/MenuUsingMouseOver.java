package com.techbodhi.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.selenium.core.SystemProp;

public class MenuUsingMouseOver {
	private static final long FIVE_HUNDRED_MILLIS = 1000;
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = SystemProp.getDriver();
		driver.get("http://store.demoqa.com/");
	}

	@Test
	public void clickOnMenu_failed_Using_xpath() {
		Actions actionbuilder = new Actions(driver);
		Action mouseOverOnMenu = actionbuilder.moveToElement(
				driver.findElement(By.linkText("Product Category"))).build();
		
		mouseOverOnMenu.perform();
		
		driver.findElement(
				By.xpath("html/body/div[2]/div/div/header/nav/ul/li[2]/ul/li[4]/a"))
				.click();

	}
	// @Test
	// public void clickOnMenu_failed_Using_LinkText(){
	// driver.findElement(By.linkText("iPhones")).click();
	// // WebDriverWait wait = new WebDriverWait(driver, 5);
	// //
	// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
	//
	// }
	
	@Test (enabled=true)
	public void mouseOverOnMyAccount() throws InterruptedException{
		
		WebElement myAccount = driver.findElement(By.xpath("html/body/div[2]/div/div/header/div[2]/a"));
		WebElement icon = driver.findElement(By.xpath("html/body/div[2]/div/div/header/div[2]/a/span[1]"));
		
		Actions actionBuilder = new Actions(driver);
		Action mouseOver = actionBuilder.moveToElement(myAccount).build();
		
		String cssValue = icon.getCssValue("margin-top");
		System.out.println("Before" + cssValue);
		
		mouseOver.perform();
		Thread.sleep(5000);
		
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		cssValue = icon.getCssValue("margin-top");
		System.out.println("After" + cssValue);
		driver.quit();
	}

}
