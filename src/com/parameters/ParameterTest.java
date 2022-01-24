package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"browser","url","loginid"})
	public void parametersPassing(String browser, String url, String loginid) {
	if(browser.equals("chrome"))	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.geco.driver", "./drivers/gecodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	//driver.get("https://login.yahoo.com/");
	driver.get(url);
	driver.findElement(By.id("login-username")).clear();
	//driver.findElement(By.id("login-username")).sendKeys("smitavasipalli");
	driver.findElement(By.id("login-username")).sendKeys(loginid);
	driver.findElement(By.id("login-signin")).click();
		
	}

}
