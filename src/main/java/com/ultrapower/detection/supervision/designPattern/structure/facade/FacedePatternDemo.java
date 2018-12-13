package com.ultrapower.detection.supervision.designPattern.structure.facade;

public class FacedePatternDemo {

	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
	
}
