package com.ultrapower.detection.supervision.designPattern.create.abstractFactory;

public class ShapeFactory extends AbstractFactory {

	public Color getColor(String color) {
		return null;
	}

	public Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shape.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shape.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
