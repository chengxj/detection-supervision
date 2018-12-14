package com.ultrapower.detection.supervision.designPattern.behavior.chain;

public class ConsoleLogger extends AbstractLogger {
	
	public ConsoleLogger(int level) {
		this.level = level;
	}

	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}
	
}
