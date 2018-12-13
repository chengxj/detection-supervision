package com.ultrapower.detection.supervision.designPattern.create.prototype;

public class Rectangle extends Shape {
	
	public Rectangle() {
		type = "Rectangle";
	}

	void draw() {
		System.out.println("Inside Rectanlge::draw() method.");
	}

}
