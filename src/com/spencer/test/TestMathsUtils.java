package com.spencer.test;

import com.spencer.junit.MyTestCase;

public class TestMathsUtils  extends MyTestCase{

	public void testAdd() {
		MathsUtils utils = new MathsUtils();
		int resutl = utils.add(1, 2);
		System.out.println("test1: " + resutl);
	}
	
	public void testAdd2() {
		MathsUtils utils = new MathsUtils();
		int resutl = utils.add(1, 2);
		System.out.println("test2: " + resutl);
	}
}
