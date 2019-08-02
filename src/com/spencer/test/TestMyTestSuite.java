package com.spencer.test;

import org.junit.Test;

import com.spencer.junit.MyTestSuite;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

abstract class TestMyTestSuite {

	
	public static void main(String[] args) {
		MyTestSuite suite = new MyTestSuite(TestMathsUtils.class);
		suite.addTestSuite(TestMathsUtils.class);
		suite.run();
	}
}
