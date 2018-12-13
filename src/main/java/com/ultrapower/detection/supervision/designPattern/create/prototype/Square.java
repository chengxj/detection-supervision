package com.ultrapower.detection.supervision.designPattern.create.prototype;

public class Square extends Shape {
	
	public Square() {
		type = "Square";
	}

	void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
