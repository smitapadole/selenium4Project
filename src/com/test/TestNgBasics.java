package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {

	@BeforeSuite
	public void setup() {
	System.out.println("Driver Setup");	
	}
	
	@BeforeTest
	public void getBrowser() {
		System.out.println("Open Browser window");
	}
	
	@BeforeClass
	public void enterURL(){
	System.out.println("Entered URL");
	}
	
	@BeforeMethod
	public void loadPage() {
		System.out.println("Page Loaded");
	}
	
	@Test
	public void testTitle() {
		System.out.println("Google Title Test");
	}
	
	@AfterMethod
	public void deleteCookies() {
		System.out.println("Delete cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Closed Browser");
	}
	
}
 
