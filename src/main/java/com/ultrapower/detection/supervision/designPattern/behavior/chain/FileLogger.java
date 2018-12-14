package com.ultrapower.detection.supervision.designPattern.behavior.chain;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}
	
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}

}
