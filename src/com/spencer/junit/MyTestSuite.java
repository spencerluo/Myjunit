package com.spencer.junit;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTestSuite implements MyTest{
	
	private List<MyTest> tests = new ArrayList<MyTest>();

	public MyTestSuite(Class clazz) {
		if (clazz.getModifiers() != 1) {
			warn(clazz + "'s modifier is not public");
		}
	
		for (Method method: clazz.getMethods()) {
			addTestCases(method, clazz);
		}
	}

	private void addTestCases(Method method, Class clazz) {
		if (isTestMethod(method)) {
			try {
				Object instance = clazz.newInstance();
				if (instance instanceof MyTest) {
					MyTestCase testCase = (MyTestCase)instance;
					testCase.setName(method.getName());
					
					addTest(testCase);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addTest(MyTest test) {
		tests.add(test);
	}
	
	public void addTestSuite(Class clazz) {
		tests.add(new MyTestSuite(clazz));
	}

	private boolean isTestMethod(Method method) {
		String name = method.getName();
		Parameter[] parameters = method.getParameters();
		Class returnType = method.getReturnType();
		return name.startsWith("test") && parameters.length == 0 && returnType == Void.TYPE;
	}

	private void warn(String string) {
		
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public void run() {
		for (MyTest test: tests) {
			test.run();
		}
	}

}
