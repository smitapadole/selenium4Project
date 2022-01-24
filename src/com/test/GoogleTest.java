package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.get("http://google.com");
	}

	@Test(priority=1,groups="loadPage")
	public void testTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2,groups="loadPage")
	public void testLogo() {
		boolean isDisplayed = driver.findElement(By.id("hplogo")).isDisplayed();
		//boolean isDisplayed1 = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println(isDisplayed);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
