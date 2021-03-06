package com.ultrapower.detection.supervision.designPattern.structure.bridge;

public abstract class Shape {
	
	protected DrawAPI drawAPI;
	
	protected Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();
	
}
