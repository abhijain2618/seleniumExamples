package com.techbodhi.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;



public class PageScrollExample {

	WebDriver driver;
	@BeforeClass
	public void setUp(){
		driver = SystemProp.getDriver("firefox");
	}
	
	@Test
	public void scrollExampleOne(){
		driver.get("https://www.flipkart.com/haier-6-kg-fully-automatic-top-load-washing-machine/p/itme2gpjmhez5shb?pid=WMNE2GP44XA3KGBG&fm=merchandising&iid=1d08ab34-a517-46e2-987c-14f413cabfec.WMNE2GP44XA3KGBG.PRODUCTSUMMARY&otracker=bp_reco_recently_viewed_reco_recently_viewed");

		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		WebElement backToTop = driver.findElement(By.xpath(".//*[contains(text(),'Back to top')]"));
		backToTop.click();
	}
}
