package com.ultrapower.detection.supervision.designPattern.structure.flyweight;

import java.util.HashMap;

public class ShapeFactory {
	
	private static final HashMap<String, Shape> circleMap = new HashMap<>();
	
	public static Shape getCircle(String color) {
		Circle circle = (Circle)circleMap.get(color);
		if (null == circle) {
			circle = new Circle(color);
			circleMap.put(color, circle);			
			System.out.println("Creating cricle of color : " + color);
		} 
		return circle;
	}
	
}
