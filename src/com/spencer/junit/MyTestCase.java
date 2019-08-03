package com.spencer.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static com.spencer.junit.MyAssert.fail;
public class MyTestCase implements MyTest{

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int count() {
		return 1;
	}

	@Override
	public void run(MyTestResult result) {
		result.run(this);

	}
	
	public void runBare() {
		before();
		try {
			runTest();
		} finally {
			after();
		}
	}
	
	public void runTest() {
		Method method;
		try {
			method = getClass().getMethod(name, null);
			method.invoke(this, null);
		} catch (NoSuchMethodException e) {
			fail("no such method");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void before() {
		
	}

	public void after() {
		
	}
}
