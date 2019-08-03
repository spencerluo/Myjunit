package com.spencer.test;


import com.spencer.junit.MyPrinterListener;
import com.spencer.junit.MyTestListener;
import com.spencer.junit.MyTestResult;
import com.spencer.junit.MyTestSuite;


abstract class TestMyTestSuite {

	
	public static void main(String[] args) {
		MyTestSuite suite = new MyTestSuite(TestMathsUtils.class);
//		suite.addTestSuite(TestMathsUtils.class);
		MyTestListener listener = new MyPrinterListener(System.out);
		MyTestResult result = new MyTestResult();
		result.addListener(listener);
		suite.run(result);
		System.out.println(suite.count());
	}
}
