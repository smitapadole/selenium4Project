package com.test;

import org.testng.annotations.Test;

public class invocationCountTest {
	
	@Test(invocationCount=10)
	public void sum() {
	
	int a =10, b=20;
	System.out.println("Sum is ====> "+(a+b));
	}
}
