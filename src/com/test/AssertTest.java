package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertTest {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com");		
	}
	
	@Test
	public void AssertTitle()
	{
		String title = driver.getTitle();
		System.out.println("********** "+title);
		Assert.assertEquals(title,"Google");
		//Assert.assertEquals(title,"Google1","Title is not Matched");
	}
	
	@Test()
	public void testLogo() {
		boolean isDisplayed = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Logo is not present");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
