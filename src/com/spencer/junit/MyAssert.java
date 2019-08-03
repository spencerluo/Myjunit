package com.spencer.junit;

public class MyAssert {

	public static void assertTrue(String hope, String acturally) {
		if (!compareString(hope, acturally)) {
			fail("hope: " + hope + "but: " + acturally);
		}
	}
	
	public static void assertTrue(int hope, int acturally) {
		if (!compareInt(hope, acturally)) {
			fail("hope: " + hope + "but: " + acturally);
		}
	}
	
	
	
	public static boolean compareString(String a, String b) {
		return a.equals(b);
	}
	
	
	public static boolean compareInt(int a, int b) {
		return a == b;
	}
	
	public static void fail(String message) {
		throw new AssertException(message);
	}
}
