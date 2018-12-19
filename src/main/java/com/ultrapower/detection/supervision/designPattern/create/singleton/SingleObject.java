package com.ultrapower.detection.supervision.designPattern.create.singleton;

public class SingleObject {
	
	private static SingleObject instance = new SingleObject();
	
	private SingleObject() {
		
	}
	
	public static SingleObject getInstance() {
		return instance;
	}
	
	public void showMessage() {
		System.out.println("Hello World!");
	}
	
	

}
