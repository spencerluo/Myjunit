package com.spencer.junit;

public interface MyTestListener {

	public void startTest();
	
	public void endTest();
	
	public void testFail(String result);
	
	public void testError(String result);
}
