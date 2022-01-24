package com.test;

import org.testng.annotations.Test;

public class ExceptionHandling {
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void handleException() {
		int x = Integer.parseInt("123A");
	}

}
