package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loadPage() {
		System.out.println("Page loaded"); 
		//int a =3/0; //exception....readTitle() will get skipped.
	}
	//@Test(priority=1, enabled=true/false, dependsOnMethods={"method1"}, groups="groupName")
	@Test(dependsOnMethods="loadPage")
	public void readTitle() {
		System.out.println("Title of Page");
	}
	
}

