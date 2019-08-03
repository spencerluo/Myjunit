package com.spencer.junit;

import java.io.IOException;
import java.io.PrintStream;

public class MyPrinterListener implements MyTestListener {
	private PrintStream pWriter;
	
	public MyPrinterListener(PrintStream out) {
		this.pWriter = out;
	}

	@Override
	public void startTest() {
	}

	@Override
	public void endTest() {
	}

	@Override
	public void testFail(String result) {
		printString(result);
	}

	@Override
	public void testError(String result) {
		printString(result);
	}
	
	private void printString(String s) {
		try {
			pWriter.write((s+"\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
