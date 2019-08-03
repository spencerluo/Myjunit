package com.spencer.junit;

import java.util.ArrayList;
import java.util.List;

public class MyTestResult {
	

	private List<MyTestListener> listeners = new ArrayList<MyTestListener>();
	
	public void addListener(MyTestListener listener) {
		listeners.add(listener);
	}
	
	public void startTestListen() {
		for (MyTestListener listener: listeners) {
			listener.startTest();
		}
	}
	
	public void endTestListen() {
		for (MyTestListener listener: listeners) {
			listener.endTest();
		}
	}
	
	public void run(MyTestCase testCase) {
		startTestListen();
		runTest(testCase);
		endTestListen();
	}

	private void runTest(MyTestCase testCase) {
		try {
			testCase.runBare();
		} catch (RuntimeException e) {
			noticeFail(e.getMessage());
		}catch (Exception e) {
			noticeError(e.getMessage());
		}
	}

	private void noticeError(String message) {
		for (MyTestListener listener: listeners) {
			listener.testError(message);
		}
	}

	private void noticeFail(String message) {
		for (MyTestListener listener: listeners) {
			listener.testFail(message);
		}
	}


	
	
}
